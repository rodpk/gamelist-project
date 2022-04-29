package br.com.rodpk.gamelist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.model.Category;
import br.com.rodpk.gamelist.model.dto.CategoryResponse;
import br.com.rodpk.gamelist.model.enums.CategoryEnum;
import br.com.rodpk.gamelist.repository.CategoryRepository;

@Service
public class CategoryService {
    

    @Autowired
    private CategoryRepository repository;

    public CategoryResponse findById(Integer id) {
       var genre = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
       return CategoryResponse.of(genre);
    }

    public void populateDatabase() {
        List<Category> categories = new ArrayList<>();
        
        for (CategoryEnum category : CategoryEnum.class.getEnumConstants()) {
            categories.add(new Category(category));   
        }
        repository.saveAll(categories);
    }

    public List<CategoryResponse> findAll() {
        return null;
    }

}
