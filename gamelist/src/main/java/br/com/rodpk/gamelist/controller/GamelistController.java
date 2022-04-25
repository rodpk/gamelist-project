package br.com.rodpk.gamelist.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class GamelistController {
    

    @GetMapping("status")
    public ResponseEntity<HashMap<String, Object>> status() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("service", "Gamelist API");
        response.put("status", "OK");
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
