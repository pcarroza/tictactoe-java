package main.views.console;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
import main.views.console.tools.GameManagerView;

public class GameView implements PlacementControllerVisitor {

    private final GameManagerView gameManagerView;

    public GameView(BoardView boardView) {
        assert boardView != null;
        gameManagerView = new GameManagerView(boardView);
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController controller) {
        gameManagerView.setPlacementCoordinateView(new PutTargetCoordinateView(controller.getCoordinateController()));
        gameManagerView.titleMovement("Pone ", controller.take());
        gameManagerView.put(controller);
        gameManagerView.nextToPlayer(controller);
        gameManagerView.showGame(controller);
    }

    @Override
    public void visit(MoveController controller) {
        gameManagerView.setPlacementCoordinateView(new MoveOriginCoordinateView(controller.getCoordinateController()));
        gameManagerView.titleMovement("Mueve ", controller.take());
        gameManagerView.remove(controller);
        gameManagerView.setPlacementCoordinateView(new MoveTargetCoordinateView(controller.getCoordinateController()));
        gameManagerView.put(controller);
        gameManagerView.nextToPlayer(controller);
        gameManagerView.showGame(controller);
    }
}
