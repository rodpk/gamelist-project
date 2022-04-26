package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.rodpk.gamelist.model.enums.GenreEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Genre extends BaseEntity{
 
    @Id @Column(name = "genre_id")
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private GenreEnum name;

    @ManyToMany(mappedBy = "genres")
    private Set<Game> games;

    public Genre(GenreEnum genre) {
        this.name = genre;
    }
}
