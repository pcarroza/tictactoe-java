package com.citadel.tictactoe.controllers.features.game;

public interface SaveController extends GameOperationController {

    void save();

    void resume();

    void exit();
}
