package main.views.console.modules.game;

import main.controllers.modules.game.MoveController;
import main.controllers.modules.game.PlacementController;
import main.controllers.modules.game.PlacementControllerVisitor;
import main.controllers.modules.game.PutController;
import main.controllers.modules.game.errors.ErrorReport;
import main.models.Player;
import main.models.Coordinate;

import java.util.function.Function;
import java.util.function.Supplier;

public class GameView implements PlacementControllerVisitor {

    private final ErrorReportView errorReportView;

    private final BoardView boardView;

    private Coordinate origin;

    public GameView(BoardView boardView) {
        assert boardView != null;
        this.boardView = boardView;
        errorReportView = new ErrorReportView();
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController putController) {
        titleMovement("Pone ", putController.take());
        put(putController, new PutTargetCoordinateView(putController.getCoordinateController()));
        changeToNextPlayer(putController);
        showGame(putController);
    }

    @Override
    public void visit(MoveController moveController) {
        titleMovement("Mueve", moveController.take());
        remove(moveController, new MoveOriginCoordinateView(moveController.getCoordinateController()));
        put(moveController, new MoveTargetCoordinateView(moveController.getCoordinateController(), origin));
        changeToNextPlayer(moveController);
        showGame(moveController);
    }

    private void titleMovement(String title, Player color) {
        ColorView.instance().writeln(title + " el jugador ", color);
    }

    private void remove(MoveController controller, PlacementCoordinateView view) {
        origin = getCoordinate(controller::validateOrigin, view::getCoordinate);
        controller.remove(origin);
    }

    private void put(MoveController controller, PlacementCoordinateView view) {
        Coordinate target = getCoordinate(coordinate -> controller.validateTarget(origin, coordinate), view::getCoordinate);
        controller.put(target);
    }

    private void put(PutController controller, PlacementCoordinateView view) {
        Coordinate target = getCoordinate(controller::validateTarget, view::getCoordinate);
        controller.put(target);
    }

    private Coordinate getCoordinate(Function<Coordinate, ErrorReport> controller, Supplier<Coordinate> view) {
        Coordinate target = view.get();
        ErrorReport errorReport = controller.apply(target);
        if (errorReport != null) {
            errorReportView.write(errorReport);
            target = getCoordinate(controller, view);
        }
        return target;
    }

    private void changeToNextPlayer(PlacementController placementController) {
        if (!placementController.existTicTacToe()) {
            placementController.changeTurn();
        }
    }

    private void showGame(PlacementController placementController) {
        boardView.write(placementController);
        if (placementController.existTicTacToe()) {
            ColorView.instance().writeWinner(placementController.take());
            placementController.end();
        }
    }
}
