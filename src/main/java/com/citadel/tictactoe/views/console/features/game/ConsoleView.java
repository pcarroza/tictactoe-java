package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.*;
import com.citadel.tictactoe.views.core.View;

public class ConsoleView implements View {

    private final StartView startView;

    private final GameView gameView;

    private final ContinueView continueView;

    private final SaveView saveView;

    private final UndoView undoView;

    private final RedoView redoView;

    public ConsoleView() {
        BoardView boardView = new BoardView();
        startView = new StartView(boardView);
        gameView = new GameView(boardView);
        continueView = new ContinueView();
        saveView = new SaveView();
        undoView = new UndoView();
        redoView = new RedoView();
    }

    @Override
    public void interact(GameOperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(PlacementController placementController) {
        gameView.interact(placementController);
    }

    @Override
    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }

    @Override
    public void visit(SaveController saveController) {
        saveView.interact(saveController);
    }

    @Override
    public void visit(UndoController undoController) {
        undoView.interact(undoController);
    }

    @Override
    public void visit(RedoController redoController) {
        redoView.interact(redoController);
    }
}
