package com.citadel.tictactoe.core.modules;

import com.citadel.tictactoe.controllers.modules.game.Logic;
import com.citadel.tictactoe.controllers.modules.game.GameOperationController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.game.GameRegistry;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.views.console.core.Module;
import com.citadel.tictactoe.views.core.GameView;

public class GameModule implements Module {

    private final GameSnapshot gameSnapshot;

    private final GameRegistry gameRegistry;

    public GameModule(GameRegistry gameRegistry) {
        this(null, gameRegistry);
    }

    public GameModule(GameSnapshot gameSnapshot, GameRegistry gameRegistry) {
        this.gameSnapshot = gameSnapshot;
        this.gameRegistry = gameRegistry;
    }

    @Override
    public void run() {
        Logic logic = gameSnapshot == null
                ? AppConfig.logicType().create(gameRegistry)
                : AppConfig.logicType().create(gameSnapshot, gameRegistry);
        GameView gameView = AppConfig.viewType().createGameView();
        GameOperationController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                gameView.interact(controller);
            }
        } while (controller != null);
    }
}
