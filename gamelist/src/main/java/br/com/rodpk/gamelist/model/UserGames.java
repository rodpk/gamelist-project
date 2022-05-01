package br.com.rodpk.gamelist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.rodpk.gamelist.model.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "user_games")
@EqualsAndHashCode(callSuper=false)
public class UserGames extends BaseEntity{

    @Id @Column(name = "game_user_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private Float score;

    private String review;

    private Status status;

    private boolean favorited;

}
