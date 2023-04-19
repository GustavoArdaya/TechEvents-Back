package com.accenture.techEventsBack.apiService.controllers;

import com.accenture.techEventsBack.domain.exceptions.BadJWTTokenException;
import com.accenture.techEventsBack.domain.exceptions.NotFoundException;
import com.accenture.techEventsBack.domain.exceptions.UserAlreadySignedInException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handlerException(RuntimeException ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserAlreadySignedInException.class)
    public ResponseEntity<?> handlerException(UserAlreadySignedInException ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadJWTTokenException.class)
    public ResponseEntity<?> handlerException(BadJWTTokenException ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerException(NotFoundException ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
