package main.views.console.modules.game;

import main.View;
import main.controllers.modules.game.ContinueController;
import main.controllers.modules.game.OperationController;
import main.controllers.modules.game.PlacementController;
import main.controllers.modules.game.StartController;

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
