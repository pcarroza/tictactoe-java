package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.ReplayControllerVisitor;

public interface ReplayView extends ReplayControllerVisitor {

    void interact(ReplayController controller);

}
