package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.local.LocalReplayLogic;
import com.citadel.tictactoe.controllers.features.replay.local.LocalSelectReplayController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.ReplayView;
import com.citadel.tictactoe.views.core.SelectReplayView;

public class ReplayFeature implements Feature {

    @Override
    public void run() {
        MoveHistory history = selectGame();
        if (history != null){
            replay(history);
        }
    }

    private MoveHistory selectGame() {
        LocalSelectReplayController controller = new LocalSelectReplayController();
        SelectReplayView view = AppConfig.viewType().createSelectReplayView();
        view.interact(controller);
        return controller.getSelected();
    }

    private void replay(MoveHistory history) {
        LocalReplayLogic logic = new LocalReplayLogic(history);
        ReplayView view = AppConfig.viewType().createReplayView();
        ReplayController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);
    }
}
