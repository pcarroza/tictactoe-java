package com.citadel.tictactoe.controllers.features.game;

public interface StartController extends GameOperationController, PresenterController {

    void start(int users);
}
