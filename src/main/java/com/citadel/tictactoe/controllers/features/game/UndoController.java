package com.citadel.tictactoe.controllers.features.game;

public interface UndoController extends OperationController {

    void undo();

    void cancel();

}
