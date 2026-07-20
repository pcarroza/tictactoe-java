package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.models.modules.game.Player;

enum PlayerStyle {

    OS('O', "\u001B[33m"),
    XS('X', "\u001B[34m"),
    EMPTY('·', "\u001B[90m");

    private static final String RESET = "\u001B[0m";
    private static final String BOLD  = "\u001B[1m";

    private final char symbol;
    private final String ansiColor;

    PlayerStyle(char symbol, String ansiColor) {
        this.symbol = symbol;
        this.ansiColor = ansiColor;
    }

    static PlayerStyle of(Player player) {
        return valueOf(player.name());
    }

    char symbol() {
        return symbol;
    }

    String colored() {
        return ansiColor + symbol + RESET;
    }

    String coloredBold() {
        return BOLD + ansiColor + symbol + RESET;
    }
}