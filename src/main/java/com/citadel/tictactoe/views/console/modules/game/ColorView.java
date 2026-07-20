package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.shared.Terminal;

public class ColorView {

    void write(String title, Player color) {
        Terminal.getInstance().write(title + PlayerStyle.of(color).colored());
    }

    void writeln(String title, Player color) {
        this.write(title, color);
        Terminal.getInstance().writeln();
    }

    void writeCell(Player color) {
        PlayerStyle style = PlayerStyle.of(color);
        Terminal.getInstance().write(style.colored().replace(
                String.valueOf(style.symbol()), " " + style.symbol() + " "));
    }

    void writeWinner(Player color) {
        Terminal terminal = Terminal.getInstance();
        terminal.writeln();
        terminal.writeln("  ┌─────────────────────┐");
        terminal.write  ("  │    ¡VICTORIA!  " + PlayerStyle.of(color).coloredBold());
        terminal.writeln("    │");
        terminal.writeln("  └─────────────────────┘");
    }
}