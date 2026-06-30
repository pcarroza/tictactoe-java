package main.core.features;

import main.controllers.Logic;
import main.controllers.features.game.OperationController;
import main.core.config.AppConfig;
import main.models.features.game.GameSnapshot;
import main.views.console.core.Feature;
import main.views.core.View;

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
        View view = AppConfig.viewType().create();
        OperationController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);
    }

}
