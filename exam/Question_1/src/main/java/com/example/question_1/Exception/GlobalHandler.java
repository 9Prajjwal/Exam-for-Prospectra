package com.example.question_1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserException.class)
    ResponseEntity<ErrorDetails> userExceptionHandler(UserException userException, WebRequest web) {

        ErrorDetails ed = new ErrorDetails();

        ed.setLdt(LocalDateTime.now());
        ed.setDetails(web.getDescription(false));
        ed.setMessage(userException.getMessage());

        return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
    }
}
