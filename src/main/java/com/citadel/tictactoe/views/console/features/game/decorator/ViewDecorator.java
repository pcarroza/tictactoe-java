package com.citadel.tictactoe.views.console.features.game.decorator;

import com.citadel.tictactoe.controllers.features.game.*;
import com.citadel.tictactoe.views.core.GameView;

public abstract class ViewDecorator implements GameView {

    protected final GameView wrapped;

    protected ViewDecorator(GameView wrapped) {
        assert wrapped != null;
        this.wrapped = wrapped;
    }

    @Override
    public void interact(GameOperationController operationController) {
        operationController.accept(this);
    }

    protected void beforeVisit(GameOperationController operationController) {
    }

    @Override
    public void visit(StartController startController) {
        beforeVisit(startController);
        wrapped.visit(startController);
    }

    @Override
    public void visit(PlacementController placementController) {
        beforeVisit(placementController);
        wrapped.visit(placementController);
    }

    @Override
    public void visit(ContinueController continueController) {
        beforeVisit(continueController);
        wrapped.visit(continueController);
    }

    @Override
    public void visit(SaveController saveController) {
        beforeVisit(saveController);
        wrapped.visit(saveController);
    }

    @Override
    public void visit(UndoController undoController) {
        beforeVisit(undoController);
        wrapped.visit(undoController);
    }

    @Override
    public void visit(RedoController redoController) {
        beforeVisit(redoController);
        wrapped.visit(redoController);
    }
}
