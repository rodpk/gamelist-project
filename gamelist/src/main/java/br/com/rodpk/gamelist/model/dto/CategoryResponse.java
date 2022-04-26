package br.com.rodpk.gamelist.model.dto;

import br.com.rodpk.gamelist.model.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    private Integer id;
    private String genre;

    public static CategoryResponse of(Category c) {
        var category = new CategoryResponse();
        category.setId(c.getId());
        category.setGenre(c.getName().value());
        return category;
    }

}
