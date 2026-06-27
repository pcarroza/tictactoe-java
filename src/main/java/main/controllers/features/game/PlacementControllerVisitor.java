package main.controllers.features.game;

public interface PlacementControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
