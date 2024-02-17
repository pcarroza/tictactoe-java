package main.models;

public class Turn {

    private int value = 0;

    public Turn() {
        reset();
    }

    public void reset() {
        value = 0;
    }

    public Player getColorCurrentPlayer() {
        return Player.values()[value];
    }

    public int getIndexCurrentPlayer() {
        return this.getColorCurrentPlayer().ordinal();
    }

    public void switchTurn() {
        this.value = (value + 1) % (Player.values().length - 1);
    }
}
