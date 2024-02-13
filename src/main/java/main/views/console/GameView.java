package main.views.console;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
import main.controllers.errors.ErrorReport;
import main.models.Color;
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
        this.errorReportView = new ErrorReportView();
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController controller) {
        this.titleMovement("Pone ", controller.take());
        this.put(controller, new PutTargetCoordinateView(controller.getCoordinateController()));
        this.changeToNextPlayer(controller);
        this.showGame(controller);
    }

    @Override
    public void visit(MoveController controller) {
        this.titleMovement("Mueve", controller.take());
        this.remove(controller, new MoveOriginCoordinateView(controller.getCoordinateController()));
        this.put(controller, new MoveTargetCoordinateView(controller.getCoordinateController(), this.origin));
        this.changeToNextPlayer(controller);
        this.showGame(controller);
    }

    private void titleMovement(String title, Color color) {
        ColorView.instance().writeln(title + " el jugador ", color);
    }

    private void remove(MoveController controller, PlacementCoordinateView view) {
        origin = getCoordinate(controller::validateOrigin, view::getCoordinate);
        controller.remove(origin);
    }

    private void put(MoveController controller, PlacementCoordinateView view) {
        Coordinate target = getCoordinate(coordinate -> controller.validateTarget(origin, coordinate),
                view::getCoordinate);
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
            this.errorReportView.write(errorReport);
            target = getCoordinate(controller, view);
        }
        return target;
    }

    private void changeToNextPlayer(PlacementController placementController) {
        if (!placementController.existTicTacToe()) {
            placementController.switchTurn();
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
