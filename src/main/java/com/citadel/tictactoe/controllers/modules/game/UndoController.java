package com.citadel.tictactoe.controllers.modules.game;

public interface UndoController extends GameOperationController {

    void undo();

    void cancel();
}
