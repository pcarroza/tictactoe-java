package main;

import main.controllers.OperationController;

public abstract class TicTacToe {

    private final Logic logic;

    private final View view;

    public TicTacToe() {
        view = getView();
        logic = getLogic();
    }

    protected abstract Logic getLogic();

    protected abstract View getView();

    public void run() {
        OperationController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);
    }
}
