package nineonesoft.todo.repository;

import nineonesoft.todo.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Repository
public class TodoMemoryRepositoryImpl implements TodoMemoryRepository {

    private Map<Long, Todo> map = new HashMap<>();
    private static long id = 0L;


    @Override
    public Todo save(final Todo todo) {
        todo.assignId(++id);
        return map.put(todo.getId(), todo);
    }

    @Override
    public Optional<Todo> findById(final Long id) {
        return Optional.of(map.get(id));
    }

    @Override
    public void delete(final Todo findTodo) {
        map.remove(findTodo.getId());
    }

    @Override
    public List<Todo> findAll() {
        return map.values().stream().toList();
    }
}
