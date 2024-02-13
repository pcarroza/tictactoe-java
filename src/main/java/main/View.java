package main;

import main.controllers.OperationController;
import main.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(OperationController operationController);
}
