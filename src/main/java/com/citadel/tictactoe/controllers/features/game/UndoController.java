package com.citadel.tictactoe.controllers.features.game;

public interface UndoController extends GameOperationController {

    void undo();

    void cancel();
}
