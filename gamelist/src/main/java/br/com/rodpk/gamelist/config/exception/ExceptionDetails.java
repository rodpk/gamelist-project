package br.com.rodpk.gamelist.config.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionDetails {
    
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ExceptionDetails(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
