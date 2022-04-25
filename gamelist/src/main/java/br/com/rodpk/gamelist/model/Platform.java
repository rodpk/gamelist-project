package br.com.rodpk.gamelist.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.rodpk.gamelist.model.enums.PlatformEnum;
import lombok.Data;

@Data
@Entity
public class Platform {
    

    @Id
    private Integer id;

    private PlatformEnum name;
}
