package br.com.rodpk.gamelist.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    private Integer id;

    private String name;
}
