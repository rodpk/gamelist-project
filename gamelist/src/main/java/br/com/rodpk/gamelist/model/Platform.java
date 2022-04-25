package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.rodpk.gamelist.model.enums.PlatformEnum;
import lombok.Data;

@Data
@Entity
public class Platform {
    

    @Id @Column(name = "platform_id")
    private Integer id;


    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private PlatformEnum name;

    @ManyToMany(mappedBy = "platforms")
    private Set<Game> games;
}
