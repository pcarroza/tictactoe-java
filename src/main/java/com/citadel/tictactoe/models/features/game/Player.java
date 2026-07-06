package com.citadel.tictactoe.models.features.game;

public enum Player {
    OS,
    XS,
    NONE;

    public Player other() {
        assert this != NONE;
        return this == OS ? XS : OS;
    }
}

