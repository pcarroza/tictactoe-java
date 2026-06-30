package com.citadel.tictactoe.controllers.features.game;

public interface OperationControllerVisitor {

    void visit(StartController startController);

    void visit(PlacementController setController);

    void visit(ContinueController continueController);

    void visit(SaveController saveController);

    void visit(UndoController undoController);

    void visit(RedoController redoController);
}
