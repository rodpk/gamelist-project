package br.com.rodpk.gamelist.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class ExceptionsHandler {
    

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<?> handleAuthorizationException(AuthorizationException ex) {
        var details = new ExceptionDetails(HttpStatus.UNAUTHORIZED, ex.getMessage());        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(details);
    }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<?> handsleMaxSizeException(MaxUploadSizeExceededException ex) {
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }
}
