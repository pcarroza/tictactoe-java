package main.views.core;

import main.controllers.features.game.OperationController;
import main.controllers.features.game.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(OperationController operationController);
}
