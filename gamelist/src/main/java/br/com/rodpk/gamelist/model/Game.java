package br.com.rodpk.gamelist.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "game")
@EqualsAndHashCode(callSuper=false)
public class Game extends BaseEntity{
    
    @Id @Column(name = "game_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "developer", nullable = false)
    private String developer;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "game_genres", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "game_platforms", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private List<Platform> platforms;
    
    @ManyToMany
    @JoinTable(name = "game_categories", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "overral_rating")
    private Integer overralRating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_Id", referencedColumnName = "file_id")
    private File image;

    @Column(name = "is_indie")
    private boolean isIndie;

    private String country; // enum with all countries?

    @OneToMany(mappedBy = "game")
    private Set<UserGames> users;

}
