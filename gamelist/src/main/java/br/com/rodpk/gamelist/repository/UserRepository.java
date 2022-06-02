package br.com.rodpk.gamelist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rodpk.gamelist.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "update game set active = false where id_game = :id", nativeQuery = true)
    void safeDelete(@Param("id") Integer id);

    @Query("select g from Game g where g.id = :id")
    Optional<User> findActive(@Param("id") Integer id);

    
}
