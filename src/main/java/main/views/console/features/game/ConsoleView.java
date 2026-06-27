package main.views.console.features.game;

import main.views.core.View;
import main.controllers.features.game.ContinueController;
import main.controllers.features.game.OperationController;
import main.controllers.features.game.PlacementController;
import main.controllers.features.game.SaveController;
import main.controllers.features.game.StartController;

public class ConsoleView implements View {

    private final StartView startView;

    private final GameView gameView;

    private final ContinueView continueView;

    private final SaveView saveView;

    public ConsoleView() {
        BoardView boardView = new BoardView();
        startView = new StartView(boardView);
        gameView = new GameView(boardView);
        continueView = new ContinueView();
        saveView = new SaveView();
    }

    @Override
    public void interact(OperationController operationController) {
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
}
