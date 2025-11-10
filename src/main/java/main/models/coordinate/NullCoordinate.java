package main.models.coordinate;

import main.utils.Direction;

public class NullCoordinate implements Coordinate {


    private static NullCoordinate instance;

    public static Coordinate getInstance() {
        if (instance == null) {
            instance = new NullCoordinate();
        }
        return instance;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public Direction getDirection(Coordinate coordinate) {
        return Direction.NON_EXISTENT;
    }

    @Override
    public boolean inHorizontal(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean inVertical(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean inDiagonal() {
        return false;
    }

    @Override
    public String toString() {
        return "Coordinate(NULL)";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
