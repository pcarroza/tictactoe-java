package main.views.console;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
import main.views.console.tools.GameViewManager;

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
        gameViewManager.titleMovement("Pone ", controller.getTake());
        gameViewManager.put(controller);
        gameViewManager.nextToPlayer(controller);
        gameViewManager.showGame(controller);
    }

    @Override
    public void visit(MoveController controller) {
        gameViewManager.setPlacementCoordinateView(new MoveOriginCoordinateView(controller.getCoordinateController()));
        gameViewManager.titleMovement("Mueve ", controller.getTake());
        gameViewManager.remove(controller);
        gameViewManager.setPlacementCoordinateView(new MoveTargetCoordinateView(controller.getCoordinateController()));
        gameViewManager.put(controller);
        gameViewManager.nextToPlayer(controller);
        gameViewManager.showGame(controller);
    }
}
