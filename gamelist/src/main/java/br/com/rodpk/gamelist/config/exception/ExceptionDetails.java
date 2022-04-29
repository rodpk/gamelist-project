package br.com.rodpk.gamelist.config.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionDetails {
    
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ExceptionDetails(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
