package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.modules.replay.SelectReplayController;
import com.citadel.tictactoe.controllers.modules.replay.SelectReplayControllerVisitor;

public interface SelectReplayView extends SelectReplayControllerVisitor {

    void interact(SelectReplayController controller);
}
