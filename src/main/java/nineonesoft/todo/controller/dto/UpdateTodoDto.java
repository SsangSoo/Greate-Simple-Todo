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
    private String detail;


    public static UpdateTodoDto toUpdateTodoDto(Todo todo) {
        return new UpdateTodoDto(todo.getId(), todo.getTitle(), todo.getDetail());
    }


    public UpdateTodoDto(Long id, String title, String detail) {
        this.id = id;
        this.title = title;
        this.detail = detail;
    }

    public static UpdateTodoDto createUpdateTodoDto(String title, String detail) {
        return new UpdateTodoDto(title, detail);
    }

    public UpdateTodoDto(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }



}
