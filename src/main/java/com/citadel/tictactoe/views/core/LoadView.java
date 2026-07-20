package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.modules.load.LoadController;
import com.citadel.tictactoe.controllers.modules.load.LoadControllerVisitor;

public interface LoadView extends LoadControllerVisitor {

    void interact(LoadController controller);
}
