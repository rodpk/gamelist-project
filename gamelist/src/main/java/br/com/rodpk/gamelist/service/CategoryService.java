package br.com.rodpk.gamelist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.config.exception.EntityNotFoundException;
import br.com.rodpk.gamelist.model.Category;
import br.com.rodpk.gamelist.model.dto.CategoryResponse;
import br.com.rodpk.gamelist.model.enums.CategoryEnum;
import br.com.rodpk.gamelist.repository.CategoryRepository;

@Service
public class CategoryService {
    

    @Autowired
    private CategoryRepository repository;

    private Logger log = Logger.getLogger("CategoryService");


    public CategoryResponse findById(Integer id) {
       var genre = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
       log.info(String.format("genre %s found", genre.getName()));
       return CategoryResponse.of(genre);
    }

    public void populateDatabase() {
        List<Category> categories = new ArrayList<>();
        
        for (CategoryEnum category : CategoryEnum.class.getEnumConstants()) {
            categories.add(new Category(category));   
        }
        log.info("categories saved in database");
        repository.saveAll(categories);
    }

    public List<CategoryResponse> findAll() {
        return repository.findAll().stream().map(CategoryResponse::of).collect(Collectors.toList());

    }

}
