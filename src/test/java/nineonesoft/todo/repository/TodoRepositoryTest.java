package nineonesoft.todo.repository;

import nineonesoft.todo.controller.dto.CreateTodoDto;
import nineonesoft.todo.controller.dto.UpdateTodoDto;
import nineonesoft.todo.domain.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @AfterEach
    void dataCleansing() {
        todoRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("todo를 작성한다.")
    void saveTest() {
        // given
        String title = "공부";
        String description = "퇴근 후 저녁 먹고 공부한다.";

        CreateTodoDto createTodoDto = new CreateTodoDto(title, description);

        Todo todo = Todo.createTodo(createTodoDto);

        // when
        Todo savedTodo = todoRepository.save(todo);

        // then
        assertThat(savedTodo.getId()).isNotNull();
        assertThat(savedTodo.getTitle()).isEqualTo(title);
        assertThat(savedTodo.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("작성했던 todo를 수정한다.")
    void editTest() {
        // given
        String title = "공부";
        String description = "퇴근 후 저녁 먹고 공부한다.";

        CreateTodoDto createTodoDto = new CreateTodoDto(title, description);

        Todo todo = Todo.createTodo(createTodoDto);
        Todo savedTodo = todoRepository.save(todo);

        // when
        title = "헬스";
        description = "퇴근 후 헬스하고 저녁먹기";

        UpdateTodoDto updateTodoDto = UpdateTodoDto.createUpdateTodoDto(title, description);
        savedTodo.updateTodo(updateTodoDto);


        // then
        Todo findTodo = todoRepository.findById(savedTodo.getId()).orElseThrow(() ->  new IllegalArgumentException("find error"));

        assertThat(findTodo.getTitle()).isEqualTo(updateTodoDto.getTitle());
        assertThat(findTodo.getDescription()).isEqualTo(updateTodoDto.getDescription());
        assertThat(findTodo.getCreated()).isEqualTo(savedTodo.getCreated());
    }

    @Test
    @DisplayName("여러 todo는 id가 서로 달라야한다.")
    void isNonEqualTodoIdTest() {
        // given
        String title = "공부";
        String description = "퇴근 후 저녁 먹고 공부한다.";
        CreateTodoDto createTodoDto1 = new CreateTodoDto(title, description);
        Todo todo1 = Todo.createTodo(createTodoDto1);

        Todo savedTodo1 = todoRepository.save(todo1);


        title = "헬스";
        description = "퇴근 후 헬스하고 저녁먹기";
        CreateTodoDto createTodoDto2 = new CreateTodoDto(title, description);
        Todo todo2 = Todo.createTodo(createTodoDto2);

        Todo savedTodo2 = todoRepository.save(todo2);


        // when // then
        assertThat(savedTodo1.getId()).isNotEqualTo(savedTodo2.getId());
    }


}