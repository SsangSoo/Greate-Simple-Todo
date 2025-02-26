package nineonesoft.todo.controller.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseTodo {
    private Long id;
    private String title;
    private String detail;

    private LocalDateTime created;
    private LocalDateTime updated;


    @Builder
    public ResponseTodo(Long id, String title, String detail, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.created = created;
        this.updated = updated;
    }
}
