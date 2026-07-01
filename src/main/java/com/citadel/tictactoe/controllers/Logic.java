package com.citadel.tictactoe.controllers;

import com.citadel.tictactoe.controllers.features.game.GameOperationController;

public interface Logic {

    GameOperationController getController();
}
