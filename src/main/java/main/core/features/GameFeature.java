package main.core.features;

import main.controllers.Logic;
import main.controllers.features.game.OperationController;
import main.views.console.core.Feature;
import main.views.core.View;

public class GameFeature implements Feature {

    private final Logic logic;

    private final View view;

    public GameFeature(Logic logic, View view) {
        this.logic = logic;
        this.view = view;
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
