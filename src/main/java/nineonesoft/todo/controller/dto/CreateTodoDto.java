package nineonesoft.todo.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateTodoDto {

    private String title;
    private String description;


    public CreateTodoDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
