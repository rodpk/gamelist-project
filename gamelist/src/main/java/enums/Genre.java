package br.com.gamelist.gamelist.enums;

import br.com.gamelist.gamelist.utils.EncodableEnum;
import br.com.gamelist.gamelist.utils.JpaEnumConverter;

public enum Genre implements EncodableEnum<String>{

    SANDBOX ("SANDBOX"),
    FPS ("FPS"),
    ACTION_ADVENTURE ("ACTION-ADVENTURE"),
    PLATFORMER ("PLATFORMER"),
    SOULS_LIKE ("SOULS LIKE"),
    METROIDVANIA ("METROIDVANIA"),
    SIMULATION ("SIMULATION"),
    SPORTS ("SPORTS"),
    STRATEGY ("STRATEGY"),
    MMO ("MMO"),
    MOBA ("MOBA"),
    SURVIVAL ("SURVIVAL"),
    HORROR ("HORROR"),
    J_RPG ("J-RPG"),
    PUZZLE ("PUZZLE");



    private final String id;

    Genre(String id) { this.id = id; }

    @javax.persistence.Converter(autoApply = true)
    public static class Converter extends JpaEnumConverter<String, Genre> {
        public Converter(){
            super(Genre.class);
        }
    }

    @Override
    public String token() {
        return id;
    }

}
