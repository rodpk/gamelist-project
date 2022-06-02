package br.com.rodpk.gamelist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rodpk.gamelist.model.Game;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = "select * from game g where g.active = true", nativeQuery = true)
    List<Game> selectAllActiveNative();

    @Query(value = "select g from Game g")
    List<Game> selectAllJPA();
    
}
