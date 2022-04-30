package br.com.rodpk.gamelist.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
