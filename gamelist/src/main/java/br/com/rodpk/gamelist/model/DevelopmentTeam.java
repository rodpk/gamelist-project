package br.com.rodpk.gamelist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.rodpk.gamelist.model.dto.DevTeamRequest;
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
    @JsonBackReference 
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    public static DevelopmentTeam of(DevTeamRequest request) {
        var team = new DevelopmentTeam();
        team.setGame(new Game(request.getGameId()));
        team.setName(request.getName());
        team.setPosition(request.getPosition());
        return team;
    }

}
