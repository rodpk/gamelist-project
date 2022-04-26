package br.com.rodpk.gamelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodpk.gamelist.model.dto.CategoryResponse;
import br.com.rodpk.gamelist.service.CategoryService;

@RestController
@RequestMapping("/genres/")
public class GenreController {
    
    @Autowired
    CategoryService service;

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("populate")
    public ResponseEntity<?> populate() {
        service.populateDatabase();
        return ResponseEntity.ok("done");
    }
}
