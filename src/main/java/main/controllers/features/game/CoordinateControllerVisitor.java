package main.controllers.features.game;

public interface CoordinateControllerVisitor {

    void visit(UserCoordinateController userCoordinateController);

    void visit(RandomCoordinateController randomCoordinateController);
}
