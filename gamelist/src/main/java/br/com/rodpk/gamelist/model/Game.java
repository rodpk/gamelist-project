package br.com.rodpk.gamelist.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "game")
public class Game {
    

    @Id
    @Column(name = "ID_GAME")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DEVELOPER", nullable = false)
    private String developer;


    @Column(name = "DIRECTOR", nullable = false)
    private String director;


    @Column(name = "DESCRIPTION")
    private String description;

    //private List<GenreEnum> genres;

    //private List<PlataformEnum> platforms;

    //private List<Category> categories;

    @Column(name = "RELEASE_DATE")

    private LocalDate releaseDate;


    @Column(name = "OVERRAL_RATING")
    private Integer overralRating;

    @Column(name = "IMAGE")
    private String image;

}
