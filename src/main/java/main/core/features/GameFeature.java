package main.core.features;

import main.controllers.Logic;
import main.controllers.features.game.OperationController;
import main.core.config.AppConfig;
import main.models.features.game.GameSnapshot;
import main.views.console.core.Feature;
import main.views.core.View;

public class GameFeature implements Feature {

    private final Logic logic;

    private final View view;

    public GameFeature() {
        this.logic = AppConfig.logicType().create();
        this.view = AppConfig.viewType().create();
    }

    public GameFeature(GameSnapshot snapshot) {
        this.logic = AppConfig.logicType().create(snapshot);
        this.view = AppConfig.viewType().create();
    }

    public void run() {
        OperationController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }
}
