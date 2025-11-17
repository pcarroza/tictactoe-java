package main.models.modules.game.coordinate;

import main.utils.Direction;

public interface Coordinate {

    Coordinate NULL = NullCoordinate.getInstance();

    boolean isNull();

    Direction getDirection(Coordinate coordinate);

    boolean inHorizontal(Coordinate coordinate);

    boolean inVertical(Coordinate coordinate);

    boolean inDiagonal();
}
