package main.controllers.modules.game;

public interface PlacementControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
