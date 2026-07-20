package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Player;

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
        game.changeTurn();
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

    public MoveHistory getMoveHistory() {
        return game.getMoveHistory();
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

    public void save() {
        game.save();
    }

    public void resume() {
        game.resume();
    }
}
