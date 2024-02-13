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
        return this.getRandomCoordinate(this::isOccupiedByCurrentPlayer);
    }

    @Override
    public Coordinate getTarget() {
        return this.getRandomCoordinate(this::isEmpty);
    }

    @Override
    public Coordinate getTarget(Coordinate origin) {
        assert origin != null;
        return this.getRandomCoordinate((coordinate) -> !origin.equals(coordinate));
    }

    private Coordinate getRandomCoordinate(Predicate<Coordinate> isTrue) {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        while (!isTrue.test(coordinate)) {
            coordinate.random();
        }
        return coordinate;
    }

    @Override
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }
}

