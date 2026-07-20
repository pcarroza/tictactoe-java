package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;
import com.citadel.tictactoe.controllers.modules.replay.ReplayControllerVisitor;

public interface ReplayView extends ReplayControllerVisitor {

    void interact(ReplayController controller);

}
