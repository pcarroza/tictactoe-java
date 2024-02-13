package main.models.flat;

import main.models.Board;
import main.models.Color;
import main.models.Coordinate;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Flat {

    Board put(Coordinate coordinate);

    int getNumberOfPlayers();

    Color getColor(Coordinate coordinate);

    boolean isComplete();

    Color take();

    int currentPlayer();

    Board change();

    boolean isExistTicTacToe();

    boolean areCoordinatesInSameDirection(Set<Coordinate> set);

    void isEmpty(Coordinate coordinate);

    void isOccupiedByPlayer(Coordinate coordinate);

    void clear();

    void remove(Coordinate origin);

    List<Coordinate> getEmptyCoordinates();

    List<Coordinate> getPlayerCoordinates();

    List<Coordinate> getCoordinates(MapFlat.ColorComparator colorComparator);
}
