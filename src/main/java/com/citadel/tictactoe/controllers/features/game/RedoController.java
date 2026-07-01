package com.citadel.tictactoe.controllers.features.game;

public interface RedoController extends GameOperationController {

    void redo();

    void cancel();

}
