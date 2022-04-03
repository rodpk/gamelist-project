package br.com.rodpk.gamelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodpk.gamelist.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
