package main.models;

public class Turn {

    private int value = 0;

    public Turn() {
        reset();
    }

    public void reset() {
        value = 0;
    }

    public Color getColorCurrentPlayer() {
        return Color.values()[value];
    }

    public int getIndexCurrentPlayer() {
        return this.getColorCurrentPlayer().ordinal();
    }

    public void switchTurn() {
        this.value = (value + 1) % (Color.values().length - 1);
    }
}
