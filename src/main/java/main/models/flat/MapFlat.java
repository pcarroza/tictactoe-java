package main.models.flat;

import main.models.Board;
import main.models.Player;
import main.models.Coordinate;
import main.models.Turn;

import java.util.*;

public class MapFlat implements Flat {

    private static final int NUMBER_OF_PLAYERS = 2;

    private final Turn turn;

    public final Map<Player, Set<Coordinate>> flat;

    public MapFlat() {
        this.flat = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            this.flat.put(Player.values()[i], new HashSet<>());
        }
        this.turn = new Turn();
    }

    @Override
    public Board put(Coordinate coordinate) {
        return null;
    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public Player getColor(Coordinate coordinate) {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Player take() {
        return null;
    }

    @Override
    public int currentPlayer() {
        return 0;
    }

    @Override
    public Board change() {
        return null;
    }

    @Override
    public boolean isExistTicTacToe() {
        return false;
    }

    @Override
    public boolean areCoordinatesInSameDirection(Set<Coordinate> set) {
        return false;
    }

    @Override
    public void isEmpty(Coordinate coordinate) {

    }

    @Override
    public void isOccupiedByPlayer(Coordinate coordinate) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void remove(Coordinate origin) {

    }

    @Override
    public List<Coordinate> getEmptyCoordinates() {
        return null;
    }

    @Override
    public List<Coordinate> getPlayerCoordinates() {
        return null;
    }

    @Override
    public List<Coordinate> getCoordinates(ColorComparator colorComparator) {
        return null;
    }

    public interface ColorComparator {
        boolean isEqualsColor(Coordinate coordinate);
    }
}
