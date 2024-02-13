package main.models;

import main.models.board.ConcreteCoordinate;
import main.models.board.SquareBoundedCoordinate;

public class Coordinate extends SquareBoundedCoordinate {

    public static final int DIMENSION = 3;

    public Coordinate(ConcreteCoordinate coordinate) {
        super(coordinate);
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    public Coordinate() {
        this(0, 0);
    }

    @Override
    protected int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }
}
