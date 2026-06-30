package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.features.load.LoadController;
import com.citadel.tictactoe.controllers.features.load.LoadControllerVisitor;

public interface LoadView extends LoadControllerVisitor {

    void interact(LoadController controller);
}
