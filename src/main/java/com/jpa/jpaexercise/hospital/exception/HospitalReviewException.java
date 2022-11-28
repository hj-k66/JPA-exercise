package com.jpa.jpaexercise.hospital.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HospitalReviewException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;

    @Override
    public String toString() {
        if(message == null) return errorCode.getMessage();
        return String.format("%s. %s",
                errorCode.getStatus(), message);
    }
}
