package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.features.replay.SelectReplayController;
import com.citadel.tictactoe.controllers.features.replay.SelectReplayControllerVisitor;

public interface SelectReplayView extends SelectReplayControllerVisitor {

    void interact(SelectReplayController controller);
}
