package main.core.logics.game;

import main.controllers.Logic;
import main.controllers.features.game.OperationController;
import main.views.core.View;

public class GameLogic {

    private final Logic logic;

    private final View view;

    public GameLogic(Logic logic, View view) {
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
