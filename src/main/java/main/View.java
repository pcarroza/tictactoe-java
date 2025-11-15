package main;

import main.controllers.modules.game.OperationController;
import main.controllers.modules.game.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(OperationController operationController);
}
