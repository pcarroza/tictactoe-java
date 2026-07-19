package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.local.LocalSelectReplayController;
import com.citadel.tictactoe.controllers.features.replay.local.logic.LocalReplayLogic;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.ReplayView;
import com.citadel.tictactoe.views.core.SelectReplayView;

public class ReplayFeature implements Feature {

    private final GameHistoryRegistry gameHistoryRegistry;

    public ReplayFeature(GameHistoryRegistry gameHistoryRegistry) {
        this.gameHistoryRegistry = gameHistoryRegistry;
    }

    @Override
    public void run() {
        MoveHistory history = selectGame();
        if (history != null){
            replay(history);
        }
    }

    @Override
    public boolean isAvailable() {
        return gameHistoryRegistry.size() > 0;
    }

    private MoveHistory selectGame() {
        LocalSelectReplayController controller = new LocalSelectReplayController(gameHistoryRegistry);
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
