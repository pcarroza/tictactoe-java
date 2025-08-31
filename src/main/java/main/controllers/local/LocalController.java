package main.controllers.local;

import main.models.Coordinate;
import main.models.Player;
import main.models.Game;

class LocalController {

    private final Game game;

    protected LocalController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected Game getGame() {
        return game;
    }

    protected int getNumberOfPlayers() {
        return game.getNumberOfPlayers();
    }

    public Player take() {
        return game.take();
    }

    public void put(Coordinate target) {
        assert target != null;
        game.put(target);
    }

    public void remove(Coordinate origin) {
        assert origin != null;
        game.remove(origin);
    }

    public void clear() {
        game.clear();
    }

    public boolean existTicTacToe() {
        return game.existTicTacToe();
    }

    public void changeTurn() {
        game.switchTurn();
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return game.isEmpty(coordinate);
    }

    public boolean isOccupiedByCurrentPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return game.isOccupiedByCurrentPlayer(coordinate);
    }

    public Player getColor(Coordinate coordinate) {
        assert coordinate != null;
        return game.getColor(coordinate);
    }

    public void initialize() {
        game.initialize();
    }

    public void end() {
        game.end();
    }

    public void begin() {
        game.begin();
    }

    public void exit() {
        game.exit();
    }
}
