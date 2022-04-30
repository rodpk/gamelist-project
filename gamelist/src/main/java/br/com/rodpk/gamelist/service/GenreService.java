package br.com.rodpk.gamelist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rodpk.gamelist.config.exception.EntityNotFoundException;
import br.com.rodpk.gamelist.model.Genre;
import br.com.rodpk.gamelist.model.dto.GenreResponse;
import br.com.rodpk.gamelist.model.enums.GenreEnum;
import br.com.rodpk.gamelist.repository.GenreRepository;

public class GenreService {

    @Autowired
    private GenreRepository repository;

    public GenreResponse findById(Integer id) {
       var genre = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
       return GenreResponse.of(genre);
    }

    public void populateDatabase() {
        List<Genre> genres = new ArrayList<>();
        
        for (GenreEnum genre : GenreEnum.class.getEnumConstants()) {
            genres.add(new Genre(genre));   
        }
        repository.saveAll(genres);
    }

    public List<GenreResponse> findAll() {
        return repository.findAll().stream().map(GenreResponse::of).collect(Collectors.toList());
    }
    
}
