package br.com.rodpk.gamelist.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GameRequest {

    private String name;
    private String developer;
    private String director;
    private String description;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("is_indie")
    private Boolean indie;
    private String country;
    
}
