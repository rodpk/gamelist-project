package br.com.rodpk.gamelist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.rodpk.gamelist.model.enums.Role;
import lombok.Data;


@Data
@Entity
@Table(name = "cast")
public class Cast {


    @Id @Column(name = "cast_id")  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private Role role;

    //private Set<Game> games;
}
