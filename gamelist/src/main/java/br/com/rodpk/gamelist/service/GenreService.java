package br.com.rodpk.gamelist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rodpk.gamelist.model.Genre;
import br.com.rodpk.gamelist.model.dto.GenreResponse;
import br.com.rodpk.gamelist.model.enums.GenreEnum;
import br.com.rodpk.gamelist.repository.GenreRepository;

public class GenreService {

    @Autowired
    GenreRepository repository;

    public GenreResponse findById(Integer id) {
       var genre = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
       return GenreResponse.of(genre);
    }

    public void populateDatabase() {
        List<Genre> genres = new ArrayList<>();
        
        for (GenreEnum genre : GenreEnum.class.getEnumConstants()) {
            genres.add(new Genre(genre));   
        }
        repository.saveAll(genres);
    }
    
}
