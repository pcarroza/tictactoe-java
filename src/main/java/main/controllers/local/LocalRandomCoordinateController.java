package main.controllers.local;

import main.controllers.CoordinateControllerVisitor;
import main.controllers.RandomCoordinateController;
import main.models.Coordinate;
import main.models.Game;

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

