package main.views.console.modules.game;

import main.models.Player;
import main.utils.Terminal;

public class ColorView {

    private static ColorView colorView;

    public static ColorView instance() {
        if (colorView == null) {
            colorView = new ColorView();
        }
        return colorView;
    }

    private static final char[] COLORS = {'o', 'x', '_'};

    private ColorView() {}

    void write(String title, Player color) {
        Terminal.getInstance().write(title + getColor(color));
    }

    void writeln(String title, Player color) {
        this.write(title, color);
        Terminal.getInstance().writeln();
    }

    void writeWinner(Player color) {
        String victory = "Victoria!!!!";
        Terminal.getInstance().write(victory);
        final int MAX = 3;
        for (int i = 0; i < MAX; i++) {
            Terminal.getInstance().write(getColor(color) + "! ");
        }
        Terminal.getInstance().writeln(victory);
    }

    private char getColor(Player color) {
        return COLORS[color.ordinal()];
    }
}
