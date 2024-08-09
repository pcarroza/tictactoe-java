package main.views.console;

import main.models.Color;
import main.common.utils.Terminal;

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

    void write(String title, Color color) {
        Terminal.getInstance().write(title + getColor(color));
    }

    public void writeln(String title, Color color) {
        this.write(title, color);
        Terminal.getInstance().writeln();
    }

    public void writeWinner(Color color) {
        String victory = "Victoria!!!!";
        Terminal.getInstance().write(victory);
        final int MAX = 3;
        for (int i = 0; i < MAX; i++) {
            Terminal.getInstance().write(getColor(color) + "! ");
        }
        Terminal.getInstance().writeln(victory);
    }

    private char getColor(Color color) {
        return COLORS[color.ordinal()];
    }
}
