package com.citadel.tictactoe.models.modules.game.coordinate;

import com.citadel.tictactoe.models.modules.game.Direction;

public interface Coordinate {

    Coordinate NULL = new NullCoordinate();

    boolean isNull();

    Direction getDirection(Coordinate coordinate);

    boolean inHorizontal(Coordinate coordinate);

    boolean inVertical(Coordinate coordinate);

    boolean inDiagonal();
}
