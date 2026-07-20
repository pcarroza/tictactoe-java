package com.citadel.tictactoe.controllers.modules.game;

public interface SaveController extends GameOperationController {

    void save();

    void resume();

    void exit();
}
