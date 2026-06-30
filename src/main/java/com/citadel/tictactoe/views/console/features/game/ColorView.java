package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.shared.Terminal;

public class ColorView {

    private static ColorView colorView;

    public static ColorView instance() {
        if (colorView == null) {
            colorView = new ColorView();
        }
        return colorView;
    }

    private static final char[] SYMBOLS = {'O', 'X', '·'};

    private static final String RESET  = "[0m";
    private static final String YELLOW = "[33m";
    private static final String BLUE   = "[34m";
    private static final String GRAY   = "[90m";
    private static final String BOLD   = "[1m";

    private ColorView() {}

    void write(String title, Player color) {
        Terminal.getInstance().write(title + ansi(color) + getSymbol(color) + RESET);
    }

    void writeln(String title, Player color) {
        this.write(title, color);
        Terminal.getInstance().writeln();
    }

    void writeCell(Player color) {
        Terminal.getInstance().write(ansi(color) + " " + getSymbol(color) + " " + RESET);
    }

    void writeWinner(Player color) {
        Terminal terminal = Terminal.getInstance();
        terminal.writeln();
        terminal.writeln("  ┌─────────────────────┐");
        terminal.write  ("  │    ¡VICTORIA!  " + BOLD + ansi(color));
        terminal.write  ("" + getSymbol(color) + RESET);
        terminal.writeln("    │");
        terminal.writeln("  └─────────────────────┘");
    }

    private String ansi(Player color) {
        if (color == Player.OS) return YELLOW;
        if (color == Player.XS) return BLUE;
        return GRAY;
    }

    private char getSymbol(Player color) {
        return SYMBOLS[color.ordinal()];
    }
}
