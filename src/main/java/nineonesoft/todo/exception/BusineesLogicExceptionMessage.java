package nineonesoft.todo.exception;

import lombok.Getter;

public enum BusineesLogicExceptionMessage {

    ALREADY_ID_EXISTS("이미 아이디가 존재합니다.");

    @Getter
    private String message;

    BusineesLogicExceptionMessage(String message) {
        this.message = message;
    }
}
