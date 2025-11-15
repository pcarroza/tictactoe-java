package main.controllers.modules.game;

public interface CoordinateControllerVisitor {

    void visit(UserCoordinateController userCoordinateController);

    void visit(RandomCoordinateController randomCoordinateController);
}
