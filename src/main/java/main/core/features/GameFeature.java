package main.core.features;

import main.controllers.Logic;
import main.controllers.features.game.OperationController;
import main.controllers.features.game.local.logic.LocalLogic;
import main.views.console.core.Feature;
import main.views.console.features.game.ConsoleView;
import main.views.core.View;

public class GameFeature implements Feature {

    private final Logic logic;

    private final View view;

    public GameFeature() {
        this.logic = new LocalLogic();
        this.view = new ConsoleView();
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
