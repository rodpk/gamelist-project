package br.com.rodpk.gamelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodpk.gamelist.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
