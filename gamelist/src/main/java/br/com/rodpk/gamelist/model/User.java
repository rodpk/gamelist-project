package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    
    @Id @Column(name = "user_id")
    private Integer id;

    private String name;
    
    private String email;

    
    @OneToMany(mappedBy = "user")
    private Set<UserGames> games;
}
