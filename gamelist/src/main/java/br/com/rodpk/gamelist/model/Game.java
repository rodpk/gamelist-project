package br.com.rodpk.gamelist.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.rodpk.gamelist.model.enums.GenreEnum;
import br.com.rodpk.gamelist.model.enums.PlataformEnum;
import lombok.Data;

@Entity
@Data
public class Game {
    

    @Id
    private Long id;


    private String name;

    private String developer;

    private String director;

    private String description;

    //private List<GenreEnum> genres;

    //private List<PlataformEnum> platforms;

    //private List<Category> categories;

    private LocalDate releaseDate;

    private Integer overralRating;

    private String image;
}
