package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.RandomCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

import java.util.function.Predicate;

public class LocalRandomCoordinateController extends LocalCoordinateController
    implements RandomCoordinateController {

    public LocalRandomCoordinateController(Game game) {
        super(game);
    }

    @Override
    public Coordinate getOrigin() {
        return getRandomCoordinate(this::isOccupiedByCurrentPlayer);
    }

    @Override
    public Coordinate getTarget() {
        return getRandomCoordinate(this::isEmpty);
    }

    @Override
    public Coordinate getTarget(Coordinate origin) {
        assert origin != null;
        return getRandomCoordinate((coordinate) -> !origin.equals(coordinate));
    }

    private Coordinate getRandomCoordinate(Predicate<Coordinate> isTrue) {
        Coordinate coordinate = Coordinate.getCoordinateRandom();
        while (!isTrue.test(coordinate)) {
            coordinate = Coordinate.getCoordinateRandom();
        }
        return coordinate;
    }

    @Override
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }
}
