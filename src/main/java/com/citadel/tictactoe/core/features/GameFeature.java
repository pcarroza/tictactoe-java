package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.game.Logic;
import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.views.console.core.ConsoleContext;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.GameView;

public class GameFeature implements Feature {

    private final GameSnapshot gameSnapshot;

    private final GameRegistry gameRegistry;

    private final ConsoleContext consoleContext;

    public GameFeature(GameRegistry gameRegistry, ConsoleContext consoleContext) {
        this(null, gameRegistry, consoleContext);
    }

    public GameFeature(GameSnapshot gameSnapshot, GameRegistry gameRegistry, ConsoleContext consoleContext) {
        this.gameSnapshot = gameSnapshot;
        this.gameRegistry = gameRegistry;
        this.consoleContext = consoleContext;
    }

    @Override
    public void run() {
        Logic logic = gameSnapshot == null
                ? AppConfig.logicType().create(gameRegistry)
                : AppConfig.logicType().create(gameSnapshot, gameRegistry);
        GameView gameView = AppConfig.viewType().createGameView(consoleContext);
        GameOperationController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                gameView.interact(controller);
            }
        } while (controller != null);
    }
}
