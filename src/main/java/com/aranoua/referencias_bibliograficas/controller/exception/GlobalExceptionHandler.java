package com.aranoua.referencias_bibliograficas.controller.exception;

import com.aranoua.referencias_bibliograficas.model.MensagemException;
import com.aranoua.referencias_bibliograficas.service.exception.ObjectNotFoundException;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<MensagemException> objectNotFound(ObjectNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(new MensagemException(HttpStatus.NOT_FOUND.toString(), exception.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MensagemException> runtimeException(ObjectNotFoundException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new MensagemException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage()));
    }
}
