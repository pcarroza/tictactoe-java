package main.controllers;

public interface PlacementControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
