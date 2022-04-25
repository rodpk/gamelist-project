package br.com.rodpk.gamelist.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Platform {
    

    @Id
    private Integer id;

    private String name;
}