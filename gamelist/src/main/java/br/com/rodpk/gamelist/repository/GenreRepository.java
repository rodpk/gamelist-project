package br.com.rodpk.gamelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodpk.gamelist.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    
}
