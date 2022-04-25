package br.com.rodpk.gamelist.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.rodpk.gamelist.model.enums.GenreEnum;
import lombok.Data;


@Data
@Entity
public class Genre {
 
    @Id
    private Integer id;

    private GenreEnum name;
}
