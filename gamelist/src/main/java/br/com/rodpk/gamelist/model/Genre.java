package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.rodpk.gamelist.model.enums.GenreEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Genre extends BaseEntity{
 
    @Id @Column(name = "genre_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private GenreEnum name;

    @ManyToMany(mappedBy = "genres")
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Game> games;

    public Genre(GenreEnum genre) {
        this.name = genre;
    }
}
