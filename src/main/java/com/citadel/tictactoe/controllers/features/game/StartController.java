package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.controllers.features.game.local.ai.AiDifficulty;

public interface StartController extends GameOperationController, PresenterController {

    void start(int users, AiDifficulty difficulty);
}
