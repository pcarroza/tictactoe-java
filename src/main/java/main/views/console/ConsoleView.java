package main.views.console;

import main.View;
import main.controllers.ContinueController;
import main.controllers.OperationController;
import main.controllers.PlacementController;
import main.controllers.StartController;

public class ConsoleView implements View {

    private final StartView startView;

    private final GameView gameView;

    private final ContinueView continueView;

    public ConsoleView() {
        BoardView boardView = new BoardView();
        startView = new StartView(boardView);
        gameView = new GameView(boardView);
        continueView = new ContinueView();
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
}
