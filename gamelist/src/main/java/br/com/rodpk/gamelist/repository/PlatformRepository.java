package br.com.rodpk.gamelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodpk.gamelist.model.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    
}
