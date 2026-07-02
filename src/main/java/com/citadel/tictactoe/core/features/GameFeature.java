package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.Logic;
import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.GameView;

public class GameFeature implements Feature {

    private final GameSnapshot snapshot;

    public GameFeature() {
        this.snapshot = null;
    }

    public GameFeature(GameSnapshot snapshot) {
        this.snapshot = snapshot;
    }

    @Override
    public void run() {
        Logic logic = snapshot == null
                ? AppConfig.logicType().create()
                : AppConfig.logicType().create(snapshot);
        GameView gameView = AppConfig.viewType().create();
        GameOperationController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                gameView.interact(controller);
            }
        } while (controller != null);
    }

}
