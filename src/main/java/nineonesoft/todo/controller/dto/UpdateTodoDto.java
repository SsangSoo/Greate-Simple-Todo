package nineonesoft.todo.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nineonesoft.todo.domain.Todo;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UpdateTodoDto {

    private Long id;
    private String title;
    private String description;


    public static UpdateTodoDto toUpdateTodoDto(Todo todo) {
        return new UpdateTodoDto(todo.getId(), todo.getTitle(), todo.getDescription());
    }


    public UpdateTodoDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static UpdateTodoDto createUpdateTodoDto(String title, String description) {
        return new UpdateTodoDto(title, description);
    }

    public UpdateTodoDto(String title, String description) {
        this.title = title;
        this.description = description;
    }



}
