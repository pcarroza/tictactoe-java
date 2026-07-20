package com.citadel.tictactoe.models.modules.game.coordinate;

import com.citadel.tictactoe.models.modules.game.Direction;

public class NullCoordinate implements Coordinate {

    @Override
    public boolean isNull() {
        return true;
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
