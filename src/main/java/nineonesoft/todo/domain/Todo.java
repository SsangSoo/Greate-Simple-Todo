package nineonesoft.todo.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nineonesoft.todo.controller.dto.CreateTodoDto;
import nineonesoft.todo.controller.dto.ResponseTodo;
import nineonesoft.todo.controller.dto.UpdateTodoDto;
import nineonesoft.todo.exception.BusinessLogicException;

import java.time.LocalDateTime;
import java.util.Objects;

import static nineonesoft.todo.exception.BusineesLogicExceptionMessage.*;

@Entity
@Table(name = "todo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    /**
     * id 할당
     */
    public void assignId(Long id) {
        if(idIsNonNull()) {
            throw new BusinessLogicException(ALREADY_ID_EXISTS.getMessage());
        }
        this.id = id;
    }


    /**
     * response 응답객체
     * @param todo
     * @return
     */
    public ResponseTodo toResponse() {
        return ResponseTodo.builder()
                .id(id)
                .title(title)
                .description(description)
                .created(created)
                .updated(updated)
                .build();
    }
    
    /**
     * id가 null이냐를 따지는 private 메서드
     * assignId() 메서드의 분기처리문 중 가독성 측면에서 작성.
     * @return
     */
    private boolean idIsNonNull() {
        return Objects.nonNull(id);
    }


    /**
     * 업데이트
     * @param updateRequest
     */
    public void updateTodo(UpdateTodoDto updateRequest) {
        title = updateRequest.getTitle();
        description = updateRequest.getDescription();
        updated = LocalDateTime.now();
    }


    /**
     * 생성 팩토리 메서드
     * @param createRequest
     * @return
     */
    public static Todo createTodo(CreateTodoDto createRequest) {
        return new Todo(createRequest.getTitle(), createRequest.getDescription());
    }


    /**
     * 생성자
     * @param title
     * @param description
     */
    private Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }



}
