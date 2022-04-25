package br.com.rodpk.gamelist.config.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<?> handleAuthorizationException(AuthorizationException e) {
        int status = HttpStatus.UNAUTHORIZED.value();
        String message = e.getMessage();
        LocalDateTime timestamp = LocalDateTime.now();
        var details = new ExceptionDetails(status, message, timestamp);
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(details);
    }



}
