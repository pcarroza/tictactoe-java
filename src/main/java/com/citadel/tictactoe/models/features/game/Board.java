package com.citadel.tictactoe.models.features.game;

import com.citadel.tictactoe.shared.ClosedInterval;

import java.util.*;
import java.util.function.Predicate;

public class Board extends Subject {

    private static final int NUMBER_OF_PLAYERS = 2;

    private static final List<List<Coordinate>> LINES = buildLines();

    public final Map<Player, Set<Coordinate>> flat;

    private final Turn turn;

    private final Deque<BoardMemento> undoStack;

    private final Deque<BoardMemento> redoStack;

    private final MoveHistory history;

    public Board() {
        flat = new HashMap<>();
        for (int i = 0; i < getNumberOfPlayers(); i++) {
            flat.put(Player.values()[i], new HashSet<>());
        }
        turn = new Turn();
        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();
        history = new MoveHistory();
    }

    public void put(Coordinate coordinate) {
        assert coordinate != null : "La 'coordinate' NO puede ser 'null'";
        assert isEmpty(coordinate) : "La casilla debe estar vacía " + coordinate;
        assert isIncluded(coordinate.getRow()) : "La 'row' debe estar entre [1 - 3]";
        assert isIncluded(coordinate.getColumn()) : "La 'column' debe estar entre [1 - 3]";

        flat.get(getColorCurrentPlayer()).add(coordinate);
        history.record(new MoveRecord(getColorCurrentPlayer(), MoveType.PUT, coordinate, history.size() + 1));

        assert isMaxNumberOfColorInBoard() : "Hay más de 3 'Colors' en el 'Board'";
        assert isOccupiedByCurrentPlayer(coordinate) : "La casilla NO está ocupada por la " + coordinate;
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
        assert origin != null : "La coordinate no peude null";
        assert !isEmpty(origin) : "El no puede estar vacío";
        history.record(new MoveRecord(getColorCurrentPlayer(), MoveType.REMOVE, origin, history.size() + 1));
        flat.get(getColorCurrentPlayer()).remove(origin);
        assert isEmpty(origin) : "La " + origin + "debe estár eliminada.";
    }

    public boolean isComplete() {
        return isFull(flat);
    }

    // Pura: no depende del tablero real, solo del mapa recibido. Permite evaluar
    // posiciones hipotéticas (p.ej. búsqueda de la IA) sin mutar el Board real.
    public boolean isFull(Map<Player, Set<Coordinate>> positions) {
        int numberOfTokens = positions.values().stream().mapToInt(Set::size).sum();
        return numberOfTokens == Coordinate.DIMENSION * flat.size();
    }

    // Pura: comprueba si el conjunto recibido contiene alguna línea de victoria
    // completa,
    // sin depender del turno actual ni del tablero real (mismo uso que isFull).
    public boolean hasLine(Set<Coordinate> owned) {
        return LINES.stream().anyMatch(owned::containsAll);
    }

    private static List<List<Coordinate>> buildLines() {
        List<List<Coordinate>> lines = new ArrayList<>();
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            List<Coordinate> rowLine = new ArrayList<>();
            List<Coordinate> columnLine = new ArrayList<>();
            for (int j = 1; j <= Coordinate.DIMENSION; j++) {
                rowLine.add(new Coordinate(i, j));
                columnLine.add(new Coordinate(j, i));
            }
            lines.add(rowLine);
            lines.add(columnLine);
        }
        lines.add(List.of(new Coordinate(1, 1), new Coordinate(2, 2), new Coordinate(3, 3)));
        lines.add(List.of(new Coordinate(1, 3), new Coordinate(2, 2), new Coordinate(3, 1)));
        return lines;
    }

    public void changeTurn() {
        turn.change();
    }

    public boolean isOccupiedByCurrentPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return !isEmpty(getColorCurrentPlayer(), coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null : "La 'coordinate' NO puede ser 'null'";
        return isEmpty(Player.OS, coordinate) && isEmpty(Player.XS, coordinate);
    }

    private boolean isEmpty(Player player, Coordinate coordinate) {
        return !flat.get(player).contains(coordinate);
    }

    public void clear() {
        flat.keySet().forEach(player -> flat.get(player).clear());
        turn.reset();
        undoStack.clear();
        redoStack.clear();
        history.clear();
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
        return getCoordinates(coordinate -> getPlayer(coordinate) == Player.NONE);
    }

    public List<Coordinate> getPlayerCoordinates() {
        return getCoordinates(coordinate -> getPlayer(coordinate) == getColorCurrentPlayer());
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

    public Player getPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return flat.keySet().stream()
                .filter(color -> !isEmpty(color, coordinate))
                .findFirst()
                .orElse(Player.NONE);
    }

    public int getIndexCurrentPlayer() {
        return turn.getIndexCurrentPlayer();
    }

    public Player getColorCurrentPlayer() {
        return turn.getCurrentPlayer();
    }

    public Map<Player, Set<Coordinate>> getPositions() {
        Map<Player, Set<Coordinate>> copy = new HashMap<>();
        flat.forEach((player, coordinates) -> copy.put(player, new HashSet<>(coordinates)));
        return copy;
    }

    public void restore(GameSnapshot snapshot) {
        flat.forEach((player, coordinates) -> coordinates.clear());
        snapshot.positions().forEach((player, coordinates) -> flat.put(player, new HashSet<>(coordinates)));
        turn.set(snapshot.currentPlayerIndex());
        undoStack.clear();
        redoStack.clear();
        history.clear();
    }

    public MoveHistory getMoveHistory() {
        return history;
    }

    public void pushState() {
        undoStack.push(new BoardMemento(getPositions(), turn.getIndexCurrentPlayer()));
        redoStack.clear();
    }

    public void revert() {
        assert !undoStack.isEmpty();
        redoStack.push(new BoardMemento(getPositions(), turn.getIndexCurrentPlayer()));
        applyMemento(undoStack.pop());
    }

    public void reapply() {
        assert !redoStack.isEmpty();
        undoStack.push(new BoardMemento(getPositions(), turn.getIndexCurrentPlayer()));
        applyMemento(redoStack.pop());
    }

    public boolean canRevert() {
        return !undoStack.isEmpty();
    }

    public boolean canReapply() {
        return !redoStack.isEmpty();
    }

    private void applyMemento(BoardMemento memento) {
        flat.forEach((player, coordinates) -> coordinates.clear());
        memento.positions().forEach((player, coordinates) -> flat.put(player, new HashSet<>(coordinates)));
        turn.set(memento.turnIndex());
    }

    @Override
    public String toString() {
        return " " + flat;
    }

    public void showFlat() {
        System.out.println(flat);
    }
}
