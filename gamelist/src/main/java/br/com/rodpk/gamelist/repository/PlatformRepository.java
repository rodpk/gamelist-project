package br.com.rodpk.gamelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodpk.gamelist.model.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    
}
