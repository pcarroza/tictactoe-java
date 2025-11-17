package main.models.modules.game;

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
        return this.getCurrentPlayer().ordinal();
    }

    public void change() {
        this.value = (value + 1) % (Player.values().length - 1);
    }
}
