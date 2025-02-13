package nineonesoft.todo.repository;

import nineonesoft.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TodoRepository extends JpaRepository<Todo, Long> {



}
