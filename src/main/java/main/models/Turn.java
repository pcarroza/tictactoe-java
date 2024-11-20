package main.models;

public class Turn {

    private int value = 0;

    public Turn() {
        reset();
    }

    public void reset() {
        value = 0;
    }

    public Color getCurrentPlayer() {
        return Color.values()[value];
    }

    public int getIndexCurrentPlayer() {
        return getCurrentPlayer().ordinal();
    }

    public void change() {
        this.value = (value + 1) % (Color.values().length - 1);
    }
}
