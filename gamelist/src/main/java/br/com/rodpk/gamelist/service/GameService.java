package br.com.rodpk.gamelist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rodpk.gamelist.model.Game;
import br.com.rodpk.gamelist.repository.GameRepository;

public class GameService {

    @Autowired
    private GameRepository repository;


    public Game findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public Game save(Game game) {
        return repository.save(game);
    }


    
}
