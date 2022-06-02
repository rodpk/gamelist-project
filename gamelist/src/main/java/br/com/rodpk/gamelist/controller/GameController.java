package br.com.rodpk.gamelist.controller;

import java.util.List;

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
import br.com.rodpk.gamelist.model.dto.DevTeamRequest;
import br.com.rodpk.gamelist.model.dto.GameRequest;
import br.com.rodpk.gamelist.service.DevelopmentTeamService;
import br.com.rodpk.gamelist.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired 
    private GameService gameService;

    @Autowired 
    private DevelopmentTeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody GameRequest game) {
        return ResponseEntity.ok(gameService.save(game));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody GameRequest game, @PathVariable Long id) {
        return ResponseEntity.ok(gameService.update(id, game));
    }

    @PutMapping("{id}/image")
    public ResponseEntity<?> updateImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        return ResponseEntity.ok(gameService.updateImage(file, id));
    }

    @PostMapping("/development-team")
    public ResponseEntity<?> createDevelopmentTeam(@RequestBody List<DevTeamRequest> devs) {
        return ResponseEntity.ok(teamService.create(devs));
    }
}
