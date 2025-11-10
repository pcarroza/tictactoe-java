package main.models.coordinate;

import main.utils.ClosedInterval;
import main.utils.Direction;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Random;

public class ConcreteCoordinate implements Coordinate {

    private int row;

    private int column;

    private static final ClosedInterval<Integer> LIMITS = new ClosedInterval<>(1, main.models.Coordinate.DIMENSION);

    public ConcreteCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public void setColumn(int column) {
        assert LIMITS.isIncluded(column);
        this.column = column;
    }

    public void setRow(int row) {
        assert LIMITS.isIncluded(row);
        this.row = row;
    }

    public ConcreteCoordinate copy() {
        return new ConcreteCoordinate(getRow(), getColumn());
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        setRow(random.nextInt(main.models.Coordinate.DIMENSION));
        setColumn(random.nextInt(main.models.Coordinate.DIMENSION));
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public Direction getDirection(Coordinate coordinate) {
        if (equals(coordinate)) {
            return Direction.NON_EXISTENT;
        }
        if (inHorizontal(coordinate)) {
            return Direction.HORIZONTAL;
        }
        if (inVertical(coordinate)) {
            return Direction.VERTICAL;
        }
        if (inDiagonal() && coordinate.inDiagonal()) {
            return Direction.DIAGONAL;
        }
        return Direction.NON_EXISTENT;
    }

    @Override
    public boolean inHorizontal(Coordinate coordinate) {
        if (coordinate.isNull()) {
            return false;
        }
        return getRow() == ((ConcreteCoordinate) coordinate).getRow();
    }

    @Override
    public boolean inVertical(Coordinate coordinate) {
        if (coordinate.isNull()) {
            return false;
        }
        return getColumn() == ((ConcreteCoordinate) coordinate).getColumn();
    }

    @Override
    public boolean inDiagonal() {
        return getRow() - getColumn() == 0;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Coordinate({0}, {1})", getRow(), getColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcreteCoordinate that = (ConcreteCoordinate) o;
        return row == that.row && column == that.column;
    }
}
