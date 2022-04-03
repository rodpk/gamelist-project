package br.com.rodpk.gamelist.model.enums;

public enum GenreEnum {

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

    GenreEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
}
