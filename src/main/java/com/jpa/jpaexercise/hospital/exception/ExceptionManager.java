package com.jpa.jpaexercise.hospital.exception;

import com.jpa.jpaexercise.hospital.domain.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
   @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body(Response.error(e.getMessage()));
   }

   @ExceptionHandler(HospitalReviewException.class)
    public ResponseEntity<?> hospitalReviewExceptionHandler(HospitalReviewException e){
       return ResponseEntity.status(e.getErrorCode().getStatus())
               .body(Response.error(ErrorCode.DUPLICATED_USER_NAME.name()));
   }

}
