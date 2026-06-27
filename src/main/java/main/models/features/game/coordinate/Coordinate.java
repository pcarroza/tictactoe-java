package main.models.features.game.coordinate;

import main.models.features.game.Direction;

public interface Coordinate {

    Coordinate NULL = NullCoordinate.getInstance();

    boolean isNull();

    Direction getDirection(Coordinate coordinate);

    boolean inHorizontal(Coordinate coordinate);

    boolean inVertical(Coordinate coordinate);

    boolean inDiagonal();
}
