package br.com.rodpk.gamelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodpk.gamelist.model.dto.UserRequest;
import br.com.rodpk.gamelist.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.find(id));    
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(service.save(request));
    }
}
