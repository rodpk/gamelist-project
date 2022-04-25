package br.com.rodpk.gamelist.model.enums;

public enum CategoryEnum {
    
    ACTION("ACTION"),
    ADVENTURE("ADVENTURE"),
    RPG("RPG"),
    FPS("FPS"),
    RACING("RACING"),
    SHOOTER("SHOOTER"),
    STRATEGY("STRATEGY"),
    SPORTS("SPORTS"),
    RTS("RTS"),
    MULTIPLAYER("MULTIPLAYER"),
    FIGHTING("FIGHTING"),
    SIMULATION("SIMULATION"),
    ROLE_PLAYING("ROLE PLAYING"),
    ARCADE("ARCADE"),
    MMO("MMO"),
    PUZZLE("PUZZLE"),
    MULTI_PLATFORM("MULTI PLATFORM"),
    REALITY("REALITY"),
    MUSIC("MUSIC"),
    ADVENTURE_RPG("ADVENTURE RPG"),
    OPEN_WORLD("OPEN WORLD"),
    INDIE("INDIE"),
    MOBA("MOBA"),
    BOARD_GAME("BOARD GAME"),
    MOBILE("MOBILE"),
    STRATEGY_RPG("STRATEGY RPG"),
    JRPG("JRPG"),
    TURN_BASED("TURN BASED"),
    MULTIPLAYER_RPG("MULTIPLAYER RPG"),
    NACIONAL("NACIONAL");
    private final String value;

    CategoryEnum (String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
