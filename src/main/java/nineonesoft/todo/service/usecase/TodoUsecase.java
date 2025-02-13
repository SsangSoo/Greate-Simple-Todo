package nineonesoft.todo.service.usecase;

import nineonesoft.todo.controller.dto.CreateTodoDto;
import nineonesoft.todo.controller.dto.UpdateTodoDto;
import nineonesoft.todo.domain.Todo;

import java.util.List;

public interface TodoUsecase {

    Todo create(CreateTodoDto createRequest);
    void update(Long id, UpdateTodoDto updateRequest);
    void delete(Long id);
    Todo get(Long id);
    List<Todo> get();
}
