package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.*;
import com.citadel.tictactoe.views.console.core.ConsoleContext;
import com.citadel.tictactoe.views.core.GameView;

public class ConsoleGameView implements GameView {

    private final StartView startView;

    private final com.citadel.tictactoe.views.console.features.game.GameView gameView;

    private final ContinueView continueView;

    private final SaveView saveView;

    private final UndoView undoView;

    private final RedoView redoView;

    public ConsoleGameView(ConsoleContext consoleContext) {
        BoardView boardView = new BoardView(consoleContext);
        startView = new StartView(boardView, consoleContext);
        gameView = new com.citadel.tictactoe.views.console.features.game.GameView(boardView, consoleContext);
        continueView = new ContinueView(consoleContext);
        saveView = new SaveView(consoleContext);
        undoView = new UndoView(consoleContext);
        redoView = new RedoView(consoleContext);
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
