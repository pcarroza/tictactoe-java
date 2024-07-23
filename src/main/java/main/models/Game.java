package main.models;

import java.util.List;

public class Game {

    private final Board board;

    public Game(Observer observer) {
        this.board = new Board();
        this.board.subscribe(observer);
    }

    public void put(Coordinate target) {
        this.board.put(target);
    }

    public void remove(Coordinate origin) {
        this.board.remove(origin);
    }

    public Player take() {
        return this.board.getColorCurrentPlayer();
    }

    public int getIndexCurrentPlayer() {
        return this.board.getIndexCurrentPlayer();
    }

    public void switchTurn() {
        this.board.switchToNextPlayer();
    }

    public boolean isOccupiedByCurrentPlayer(Coordinate origin) {
        return this.board.isOccupiedByCurrentPlayer(origin);
    }

    public boolean isEmpty(Coordinate target) {
        return this.board.isEmpty(target);
    }

    public int getNumberOfPlayers() {
        return this.board.getNumberOfPlayers();
    }

    public void clear() {
        this.board.clear();
    }

    public boolean isComplete() {
        return this.board.isComplete();
    }

    public boolean existTicTacToe() {
        return this.board.existTicTacToe();
    }

    public Player getPlayer(Coordinate coordinate) {
        return this.board.getPlayer(coordinate);
    }

    public List<Coordinate> getEmptyCoordinatesCurrentPlayer() {
        return this.board.getEmptyCoordinatesCurrentPlayer();
    }

    public List<Coordinate> getOccupiedCoordinatesCurrentPlayer() {
        return this.board.getOccupiedCoordinatesCurrentPlayer();
    }

    public void initialize() {
        this.board.initialize();
    }

    public void begin() {
        this.board.begin();
    }
    
    public void end() {
        this.board.end();
    }

    public void exit() {
        this.board.exit();
    }
}
