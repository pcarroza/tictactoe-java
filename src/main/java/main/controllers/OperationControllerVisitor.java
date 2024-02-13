package main.controllers;

public interface OperationControllerVisitor {

    void visit(StartController startController);

    void visit(PlacementController setController);

    void visit(ContinueController continueController);
}

