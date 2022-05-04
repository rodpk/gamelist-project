package br.com.rodpk.gamelist.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.rodpk.gamelist.model.enums.Position;
import lombok.Data;

@Data
public class DevTeamRequest {

    @JsonProperty("game_id")
    private Long gameId;

    @JsonProperty("dev_name")
    private String name;
    
    private Position position;

    
}
