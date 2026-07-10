package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.local.LocalSelectReplayController;
import com.citadel.tictactoe.controllers.features.replay.local.logic.LocalReplayLogic;
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
        SelectReplayView selectReplayView = AppConfig.viewType().createSelectReplayView();
        selectReplayView.interact(controller);
        return controller.getSelected();
    }

    private void replay(MoveHistory history) {
        LocalReplayLogic localReplayLogic = new LocalReplayLogic(history);
        ReplayView replayView = AppConfig.viewType().createReplayView();
        ReplayController replayController;
        do {
            replayController = localReplayLogic.getController();
            if (replayController != null) {
                replayView.interact(replayController);
            }
        } while (replayController != null);
    }
}
