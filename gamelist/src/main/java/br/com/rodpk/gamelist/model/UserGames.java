package br.com.rodpk.gamelist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.rodpk.gamelist.model.enums.Status;
import lombok.Data;

@Data
@Entity
@Table(name = "user_games")
public class UserGames {

    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private float rating;

    private Status status;

}
