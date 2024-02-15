package main.models;

import main.utils.ClosedInterval;
import main.utils.Direction;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board extends Subject {

    private static final int NUMBER_OF_PLAYERS = 2;

    public final Map<Color, Set<Coordinate>> flat;

    private final Turn turn;

    public Board() {
        flat = new HashMap<>();
        for (int i = 0; i < getNumberOfPlayers(); i++) {
            flat.put(Color.values()[i], new HashSet<>());
        }
        turn = new Turn();
    }

    public void put(Coordinate coordinate) {
        assert coordinate != null : "La 'coordinate' NO puede ser 'null'";
        assert isEmpty(coordinate) : "La casilla debe estar vacía " + coordinate.toString();
        assert isIncluded(coordinate.getRow()): "La 'row' debe estar entre [1 - 3]";
        assert isIncluded(coordinate.getColumn()): "La 'column' debe estar entre [1 - 3]";

        flat.get(getColorCurrentPlayer()).add(coordinate);

        assert isMaxNumberOfColorInBoard() : "Hay más de 3 'Colors' en el 'Board'";
        assert isOccupiedByCurrentPlayer(coordinate) : "La casilla NO está ocupada por la " + coordinate.toString();
    }

    private boolean isIncluded(int value) {
        return new ClosedInterval<>(1, Coordinate.DIMENSION).isIncluded(value);
    }

    private boolean isMaxNumberOfColorInBoard() {
        return isIncluded(getLengthCoordinates());
    }

    private int getLengthCoordinates() {
        return flat.get(getColorCurrentPlayer()).size();
    }

    public void remove(Coordinate origin) {
        assert origin != null;
        assert !isEmpty(origin);
        flat.get(getColorCurrentPlayer()).remove(origin);
        assert isEmpty(origin);
    }

    public boolean isComplete() {
        int numberOfTokens = flat.keySet()
                .stream()
                .mapToInt(color -> flat.get(color).size())
                .sum();
        return numberOfTokens == Coordinate.DIMENSION * flat.keySet().size();
    }

    public void switchTurn() {
        turn.switchTurn();
    }

    public boolean isOccupiedByCurrentPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return !isEmpty(getColorCurrentPlayer(), coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null : "La 'coordinate' NO puede ser 'null'";
        return isEmpty(Color.OS, coordinate) && isEmpty(Color.XS, coordinate);
    }

    private boolean isEmpty(Color color, Coordinate coordinate) {
        return !flat.get(color).contains(coordinate);
    }

    public void clear() {
        flat.keySet().forEach(color -> flat.get(color).clear());
        turn.reset();
    }

    public boolean existTicTacToe() {
        if (isSizeCoordinatesLessThanMaximum()) {
            return false;
        }
        if (isNotTheCoordinateInDirection()) {
            return false;
        }
        return areCoordinatesInSameDirection();
    }

    private boolean isSizeCoordinatesLessThanMaximum() {
        Coordinate[] coordinates = getCoordinatesCurrentPlayer();
        return coordinates.length < Coordinate.DIMENSION;
    }

    private boolean isNotTheCoordinateInDirection() {
        Direction direction = getFirstCoordinateDirection();
        return direction == Direction.NON_EXISTENT;
    }

    private boolean areCoordinatesInSameDirection() {
        Coordinate[] coordinates = getCoordinatesCurrentPlayer();
        Direction direction = getFirstCoordinateDirection();
        for (int i = 1; i < Coordinate.DIMENSION - 1; i++) {
            if (coordinates[i].getDirection(coordinates[i + 1]) != direction) {
                return false;
            }
        }
        return true;
    }

    private Direction getFirstCoordinateDirection() {
        Coordinate[] coordinates = getCoordinatesCurrentPlayer();
        return coordinates[0].getDirection(coordinates[1]);
    }

    private Coordinate[] getCoordinatesCurrentPlayer() {
        return this.flat.get(getColorCurrentPlayer()).toArray(new Coordinate[0]);
    }

    public int getNumberOfPlayers() {
        return Board.NUMBER_OF_PLAYERS;
    }

    public List<Coordinate> getEmptyCoordinates() {
        return getCoordinates(coordinate -> getColor(coordinate) == Color.NONE);
    }

    public List<Coordinate> getPlayerCoordinates() {
        return getCoordinates(coordinate -> getColor(coordinate) == getColorCurrentPlayer());
    }

    private List<Coordinate> getCoordinates(Predicate<Coordinate> predicate) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            for (int j = 1; j <= Coordinate.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if (predicate.test(coordinate)) {
                    coordinates.add(coordinate);
                }
            }
        }
        return coordinates;
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return flat.keySet().stream()
                .filter(color -> !isEmpty(color, coordinate))
                .findFirst()
                .orElse(Color.NONE);
    }

    public int getIndexCurrentPlayer() {
        return turn.getIndexCurrentPlayer();
    }

    public Color getColorCurrentPlayer() {
        return turn.getColorCurrentPlayer();
    }

    @Override
    public String toString() {
        return " " + flat;
    }

    public void showFlat() {
        System.out.println(flat);
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.put(new Coordinate(1, 1));
        board.switchTurn();
        board.put(new Coordinate(2, 2));
        board.switchTurn();
        board.put(new Coordinate(1, 2));
        board.switchTurn();
        board.put(new Coordinate(3, 1));
        board.switchTurn();
        board.put(new Coordinate(1, 3));

        System.out.println(board.existTicTacToe());
    }
}
