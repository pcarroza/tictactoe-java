package main.views.console;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
import main.views.console.tools.GameViewManager;

public class GameView implements PlacementControllerVisitor {

    private final GameViewManager manager;

    public GameView(BoardView boardView) {
        assert boardView != null;
        manager = new GameViewManager(boardView);
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController controller) {
        manager.setPlacementCoordinateView(new PutTargetCoordinateView(controller.getCoordinateController()));
        manager.titleMovement("Pone ", controller.getTake());
        manager.put(controller);
        manager.nextToPlayer(controller);
        manager.showGame(controller);
    }

    @Override
    public void visit(MoveController controller) {
        manager.setPlacementCoordinateView(new MoveOriginCoordinateView(controller.getCoordinateController()));
        manager.titleMovement("Mueve ", controller.getTake());
        manager.remove(controller);
        manager.setPlacementCoordinateView(new MoveTargetCoordinateView(controller.getCoordinateController()));
        manager.put(controller);
        manager.nextToPlayer(controller);
        manager.showGame(controller);
    }
}
