package com.citadel.tictactoe.models.features.achievements;

public enum Achievement {
    FIRST_WIN("Primera Victoria", "Gana tu primera partida"),
    WIN_STREAK_3("Racha de 3", "Gana 3 partidas seguidas"),
    VETERAN_10_GAMES("Veterano", "Juega 10 partidas");

    private final String title;

    private final String description;

    Achievement(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
