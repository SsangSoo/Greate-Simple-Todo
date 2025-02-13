package nineonesoft.todo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nineonesoft.todo.controller.dto.CreateTodoDto;
import nineonesoft.todo.controller.dto.UpdateTodoDto;
import nineonesoft.todo.domain.Todo;
import nineonesoft.todo.repository.TodoRepository;
import nineonesoft.todo.service.usecase.TodoUsecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService implements TodoUsecase {

    private final TodoRepository todoRepository;

    @Override
    public Todo create(CreateTodoDto createRequest) {
        Todo todo = Todo.createTodo(createRequest);
        return todoRepository.save(todo);
    }


    @Override
    public void update(Long id, UpdateTodoDto updateRequest) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("update error"));
        findTodo.updateTodo(updateRequest);
    }

    @Override
    public void delete(Long id) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("find error"));
        todoRepository.delete(findTodo);
    }

    @Override
    public Todo get(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("find error"));
    }

    @Override
    public List<Todo> get() {
        return todoRepository.findAll();
    }
}
