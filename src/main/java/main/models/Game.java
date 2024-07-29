package main.models;

import java.util.List;

public class Game {

    private final Board board;

    public Game(Observer observer) {
        board = new Board();
        board.subscribe(observer);
    }

    public void put(Coordinate target) {
        board.put(target);
    }

    public void remove(Coordinate origin) {
        board.remove(origin);
    }

    public Player take() {
        return board.getColorCurrentPlayer();
    }

    public int getIndexCurrentPlayer() {
        return board.getIndexCurrentPlayer();
    }

    public void switchTurn() {
        board.switchToNextPlayer();
    }

    public boolean isOccupiedByCurrentPlayer(Coordinate origin) {
        return board.isOccupiedByCurrentPlayer(origin);
    }

    public boolean isEmpty(Coordinate target) {
        return board.isEmpty(target);
    }

    public int getNumberOfPlayers() {
        return board.getNumberOfPlayers();
    }

    public void clear() {
        board.clear();
    }

    public boolean isComplete() {
        return board.isComplete();
    }

    public boolean existTicTacToe() {
        return board.existTicTacToe();
    }

    public Player getPlayer(Coordinate coordinate) {
        return board.getPlayer(coordinate);
    }

    public List<Coordinate> getEmptyCoordinatesCurrentPlayer() {
        return board.getEmptyCoordinatesCurrentPlayer();
    }

    public List<Coordinate> getOccupiedCoordinatesCurrentPlayer() {
        return board.getOccupiedCoordinatesCurrentPlayer();
    }

    public void initialize() {
        board.initialize();
    }

    public void begin() {
        board.begin();
    }
    
    public void end() {
        board.end();
    }

    public void exit() {
        board.exit();
    }
}
