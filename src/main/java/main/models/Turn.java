package main.models;

public class Turn {

    private int value = 0;

    public Turn() {
        reset();
    }

    public void reset() {
        value = 0;
    }

    public Player getCurrentPlayer() {
        return Player.values()[value];
    }

    public int getIndexCurrentPlayer() {
        return getCurrentPlayer().ordinal();
    }

    public void switchToNextPlayer() {
        this.value = (value + 1) % (Player.values().length - 1);
    }
}
