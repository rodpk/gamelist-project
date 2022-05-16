package br.com.rodpk.gamelist.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.rodpk.gamelist.config.exception.EntityNotFoundException;
import br.com.rodpk.gamelist.model.File;
import br.com.rodpk.gamelist.model.Game;
import br.com.rodpk.gamelist.model.dto.GameRequest;
import br.com.rodpk.gamelist.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Autowired
    private FileService fileService;

    private Logger log = Logger.getLogger("GameService");


    public Game findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game not found"));
    }

    public Game save(GameRequest game) {
        var entity = Game.of(game);
        Game saved = repository.save(entity);

        log.info(String.format("Game %s saved successfully", game.getName()));
        return saved;
    }

    public Game update(Long id, GameRequest request) {
        var found = repository.findById(id);

        if (found.isEmpty()) {
            throw new EntityNotFoundException("game "+ id +" not found");
        }
        
        var entity = Game.of(request);
        entity.setId(id);

        var saved = repository.save(entity);

        log.info(String.format("Game %s updated successfully.", saved.getId()));
        return saved;
    }

    public Game updateImage(MultipartFile file, Long id) {
        File savedFile = fileService.save(file);
        Game game = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("game not found"));
        game.setImage(savedFile);
        Game updatedGame = repository.save(game);
        log.info(String.format("Game image %s saved succesfully in database.", updatedGame.getImage().getName()));
        return updatedGame;
    }

    public void howManyPeopleArePlaying() {

    }

}
