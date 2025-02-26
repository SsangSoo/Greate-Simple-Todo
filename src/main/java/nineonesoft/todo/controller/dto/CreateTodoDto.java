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
    private String detail;


    public CreateTodoDto(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }
}
