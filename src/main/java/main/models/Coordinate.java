package main.models;

import main.models.coordinate.ConcreteCoordinate;
import main.models.coordinate.SquareBoundedCoordinate;

import java.util.Random;

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

    public static Coordinate getCoordinateRandom() {
        int row = getRandomValue();
        int column = getRandomValue();
        return new Coordinate(row, column);
    }

    private static int getRandomValue() {
        return 1 + new Random(System.currentTimeMillis()).nextInt(Coordinate.DIMENSION);
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
