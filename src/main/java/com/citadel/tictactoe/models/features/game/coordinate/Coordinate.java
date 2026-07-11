package com.citadel.tictactoe.models.features.game.coordinate;

import com.citadel.tictactoe.models.features.game.Direction;

public interface Coordinate {

    Coordinate NULL = new NullCoordinate();

    boolean isNull();

    Direction getDirection(Coordinate coordinate);

    boolean inHorizontal(Coordinate coordinate);

    boolean inVertical(Coordinate coordinate);

    boolean inDiagonal();
}
