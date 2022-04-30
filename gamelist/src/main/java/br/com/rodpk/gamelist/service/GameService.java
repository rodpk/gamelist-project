package br.com.rodpk.gamelist.service;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.config.exception.EntityNotFoundException;
import br.com.rodpk.gamelist.model.Game;
import br.com.rodpk.gamelist.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    private Logger log = Logger.getLogger("GameService");


    public Game findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game not found"));
    }

    public Game save(Game game) {
        validateData(game);
        return repository.save(game);
    }

    private void validateData(Game game) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            log.info(mapper.writeValueAsString(game));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
