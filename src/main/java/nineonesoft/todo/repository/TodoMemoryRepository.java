package nineonesoft.todo.repository;

import nineonesoft.todo.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoMemoryRepository {

    Todo save(Todo todo);

    Optional<Todo> findById(Long id);

    void delete(Todo findTodo);

    List<Todo> findAll();
}
