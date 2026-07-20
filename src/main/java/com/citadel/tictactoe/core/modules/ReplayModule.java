package com.citadel.tictactoe.core.modules;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;
import com.citadel.tictactoe.controllers.modules.replay.local.LocalSelectReplayController;
import com.citadel.tictactoe.controllers.modules.replay.local.logic.LocalReplayLogic;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.views.console.core.Module;
import com.citadel.tictactoe.views.core.ReplayView;
import com.citadel.tictactoe.views.core.SelectReplayView;

public class ReplayModule implements Module {

    private final GameHistoryRegistry gameHistoryRegistry;

    public ReplayModule(GameHistoryRegistry gameHistoryRegistry) {
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
