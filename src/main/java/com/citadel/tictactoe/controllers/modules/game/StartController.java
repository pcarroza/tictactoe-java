package com.citadel.tictactoe.controllers.modules.game;

import com.citadel.tictactoe.controllers.modules.game.local.ai.AiDifficulty;

public interface StartController extends GameOperationController, PresenterController {

    void start(int users, AiDifficulty difficulty);
}
