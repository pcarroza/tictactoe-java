package main.views.console;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
import main.views.console.logic.GameViewManager;

public class GameView implements PlacementControllerVisitor {

    private final GameViewManager gameViewManager;

    public GameView(BoardView boardView) {
        assert boardView != null;
        gameViewManager = new GameViewManager(boardView);
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController controller) {
        gameViewManager.setPlacementCoordinateView(new PutTargetCoordinateView(controller.getCoordinateController()));
        gameViewManager.titleMovement("Pone ", controller.getTurn());
        gameViewManager.put(controller);
        gameViewManager.nextPlayer(controller);
        gameViewManager.showGame(controller);
    }

    @Override
    public void visit(MoveController controller) {
        gameViewManager.setPlacementCoordinateView(new MoveOriginCoordinateView(controller.getCoordinateController()));
        gameViewManager.titleMovement("Mueve ", controller.getTurn());
        gameViewManager.remove(controller);
        gameViewManager.setPlacementCoordinateView(new MoveTargetCoordinateView(controller.getCoordinateController()));
        gameViewManager.put(controller);
        gameViewManager.nextPlayer(controller);
        gameViewManager.showGame(controller);
    }
}
