package main.models.board;

import main.utils.ClosedInterval;
import main.utils.Direction;

import java.util.Random;

public abstract class SquareBoundedCoordinate {

    private Coordinate adapter;

    public SquareBoundedCoordinate(int row, int column) {
        adapter = new ConcreteCoordinate(row, column);
        assert isValid();
    }

    public SquareBoundedCoordinate(Coordinate coordinate) {
        adapter = coordinate;
    }

    public int getRow() {
        assert !isNull();
        return ((ConcreteCoordinate) adapter).getRow();
    }

    public void setRow(int row) {
        assert !isNull();
        ((ConcreteCoordinate) adapter).setRow(row);
    }

    public int getColumn() {
        assert !isNull();
        return ((ConcreteCoordinate) adapter).getColumn();
    }

    public void setColumn(int column) {
        assert !isNull();
        ((ConcreteCoordinate) adapter).setColumn(column);
    }

    public boolean isValid() {
        assert !isNull();
        ConcreteCoordinate coordinate = (ConcreteCoordinate) adapter;
        return isIncluded(coordinate.getRow()) && isIncluded(coordinate.getColumn());
    }

    public boolean isIncluded(int value) {
        return new ClosedInterval<>(1, getDimension()).isIncluded(value);
    }

    public Direction getDirection(SquareBoundedCoordinate coordinate) {
        if (equals(coordinate) || coordinate.isNull() || isNull()) {
            return Direction.NON_EXISTENT;
        }
        if (inInverse() && coordinate.inInverse()) {
            return Direction.INVERSE;
        }
        return adapter.getDirection(coordinate.adapter);
    }

    public boolean isNull() {
        return adapter.isNull();
    }

    private boolean inInverse() {
        ConcreteCoordinate coordinate = (ConcreteCoordinate) adapter;
        return coordinate.getRow() + coordinate.getColumn() == getDimension() + 1;
    }

    protected abstract int getDimension();

    @Override
    public String toString() {
        return adapter + "";
    }

    @Override
    public int hashCode() {
        return adapter.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SquareBoundedCoordinate other = (SquareBoundedCoordinate) obj;
        return adapter != null && adapter.equals(other.adapter);
    }
}
