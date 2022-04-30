package br.com.rodpk.gamelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.rodpk.gamelist.model.Game;
import br.com.rodpk.gamelist.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService service;

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game) {
        return ResponseEntity.ok(service.save(game));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Game game, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, game));
    }

    @PutMapping("{id}/image")
    public ResponseEntity<?> updateImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateImage(file, id));
    }
}
