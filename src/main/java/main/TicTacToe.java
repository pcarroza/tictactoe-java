package main;

import main.controllers.OperationController;

public abstract class TicTacToe {

    private final Logic logic;

    private final View view;

    public TicTacToe() {
        this.view = this.getView();
        this.logic = this.getLogic();
    }

    protected abstract Logic getLogic();

    protected abstract View getView();

    public void run() {
        OperationController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }
}

