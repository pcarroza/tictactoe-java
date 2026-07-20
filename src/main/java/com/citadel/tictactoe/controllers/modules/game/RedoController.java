package com.citadel.tictactoe.controllers.modules.game;

public interface RedoController extends GameOperationController {

    void redo();

    void cancel();

}
