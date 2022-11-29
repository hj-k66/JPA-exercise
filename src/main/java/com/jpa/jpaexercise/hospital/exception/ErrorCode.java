package com.jpa.jpaexercise.hospital.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"해당 userName이 중복 됩니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND,"해당 userName이 없습니다." ),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지 않습니다.");

    private HttpStatus status;
    private String message;
}
