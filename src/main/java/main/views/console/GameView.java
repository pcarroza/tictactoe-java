package main.views.console;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
import main.models.Coordinate;
import main.views.console.tools.GameManager;

public class GameView implements PlacementControllerVisitor {

    private final GameManager gameManager;

    public GameView(BoardView boardView) {
        assert boardView != null;
        gameManager = new GameManager(boardView);
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController controller) {
        gameManager.setView(new PutTargetCoordinateView(controller.getCoordinateController()));
        gameManager.titleMovement("Pone ", controller.take());
        gameManager.put(controller);
        gameManager.nextToPlayer(controller);
        gameManager.showGame(controller);
    }

    @Override
    public void visit(MoveController controller) {
        gameManager.setView(new MoveOriginCoordinateView(controller.getCoordinateController()));
        gameManager.titleMovement("Mueve ", controller.take());
        gameManager.remove(controller);
        gameManager.setView(new MoveTargetCoordinateView(controller.getCoordinateController(), null));
        gameManager.put(controller);
        gameManager.nextToPlayer(controller);
        gameManager.showGame(controller);
    }
}
