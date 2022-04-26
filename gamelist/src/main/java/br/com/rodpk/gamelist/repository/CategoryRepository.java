package br.com.rodpk.gamelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodpk.gamelist.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
