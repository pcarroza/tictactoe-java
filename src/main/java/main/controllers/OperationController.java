package main.controllers;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
