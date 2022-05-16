package br.com.rodpk.gamelist.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.rodpk.gamelist.model.Game;
import lombok.Data;

@Data
public class GameRequest {

    private String name;
    private String developer;
    // add development team

    // add cast
    private String description;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("is_indie")
    private Boolean indie;
    private String country;

    public GameRequest of(Game game) {
        var request = new GameRequest();

        request.setName(game.getName());
        request.setCountry(game.getCountry());
        request.setDeveloper(game.getDeveloper());
        return request;
    }
    
}
