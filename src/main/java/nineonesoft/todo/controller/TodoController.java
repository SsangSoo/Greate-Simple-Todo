package nineonesoft.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nineonesoft.todo.controller.dto.CreateTodoDto;
import nineonesoft.todo.controller.dto.ResponseTodo;
import nineonesoft.todo.controller.dto.UpdateTodoDto;
import nineonesoft.todo.domain.Todo;
import nineonesoft.todo.service.usecase.TodoUsecase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoUsecase todoUsecase;

    @GetMapping("/")
    public String homeController(Model model) {
        List<ResponseTodo> responseTodos = new ArrayList<>();
        for (Todo todo : todoUsecase.get()) {
            responseTodos.add(todo.toResponse());
        }
        model.addAttribute("todos", responseTodos);
        return "home";
    }


    @GetMapping("/todos/create")
    public String addTodo(Model model) {
        model.addAttribute("todo", new CreateTodoDto());
        return "todos/create";
    }

    @PostMapping("/todos")
    public String createTodo(CreateTodoDto createRequest) {
        log.info("createRequest = {}", createRequest.toString());
        todoUsecase.create(createRequest);
        return "redirect:/";
    }

    @GetMapping("/todos/edit/{id}")
    public String editTodo(Model model, @PathVariable("id") Long id) {
        Todo todo = todoUsecase.get(id);
        UpdateTodoDto updateTodoDto = UpdateTodoDto.toUpdateTodoDto(todo);
        model.addAttribute("todo", updateTodoDto);
        return "todos/edit";
    }

    @PostMapping("/todos/update/{id}")
    public String updateTodo(UpdateTodoDto updateRequest, @PathVariable("id") Long id) {
        log.info("updateRequest = {}", updateRequest.toString());
        todoUsecase.update(id, updateRequest);
        return "redirect:/";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        log.info("deleteTodo id = {}", id);
        todoUsecase.delete(id);
        return "redirect:/";
    }

}
