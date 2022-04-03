package br.com.rodpk.gamelist.model.enums;

public enum PlataformEnum {

    PC("PC"),
    NES ("NES"),
    PSP ("PSP"),
    WII ("WII"),
    PS2 ("PLAYSTATION 2"),
    PS3 ("PLAYSTATION 3"),
    PS4 ("PLAYSTATION 4"),
    PS5 ("PLAYSTATION 5"),
    SNES ("SNES"),
    OUYA ("OUYA"),
    ATARI ("ATARI"),
    GAME_BOY ("GAME BOY"),
    XBOX_ONE ("XBOX ONE"),
    XBOX_360 ("XBOX 360"),
    MEGA_DRIVE ("MEGA DRIVE"),
    XBOX_SERIES ("XBOX SERIES"),
    PLAYSTATION ("PLAYSTATION"),
    NINTENDO_64 ("NINTENDO 64"),
    SEGA_SATURN ("SEGA SATURN"),
    MASTER_SYSTEM ("MASTER SYSTEM"),
    NINTENDO_WII_U ("NINTENDO WII U"),
    SUPER_NINTENDO ("SUPER NINTENDO"),
    NINTENDO_SWITCH ("NINTENDO SWITCH"),
    NINTENDO_DS_LITE ("NINTENDO DS LITE"),
    PLAYSTATION_VITA ("PLAYSTATION VITA");

    private final String id;

    PlataformEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
}
