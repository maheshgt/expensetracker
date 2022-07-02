package com.sb.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RosurceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleResponseNotFoundException(RosurceNotFoundException exception, WebRequest request) {
        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGeneralException(Exception exception, WebRequest request) {
        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, WebRequest request) {
        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
