package br.com.rodpk.gamelist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.rodpk.gamelist.model.enums.Position;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter @Setter
@Table(name = "development_team")
public class DevelopmentTeam extends BaseEntity{
    

    @Id @Column(name = "team_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private Position position;

}
