package br.com.rodpk.gamelist.model.dto;

import br.com.rodpk.gamelist.model.Genre;
import lombok.Data;

@Data
public class GenreResponse {
    private Integer id;
    private String genre;

    public static GenreResponse of(Genre g) {
        var genre = new GenreResponse();
        genre.setId(g.getId());
        genre.setGenre(g.getName().value());
        return genre;
    }

}
