package com.jpa.jpaexercise.hospital.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"해당 userName이 중복 됩니다.");

    private HttpStatus status;
    private String message;
}
