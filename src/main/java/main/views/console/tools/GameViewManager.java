package main.views.console.tools;

import main.controllers.MoveController;
import main.controllers.PlacementController;
import main.controllers.PutController;
import main.controllers.errors.ErrorReport;
import main.models.Coordinate;
import main.models.Color;
import main.views.console.BoardView;
import main.views.console.ColorView;
import main.views.console.ErrorReportView;
import main.views.console.PlacementCoordinateView;

import java.util.function.Function;
import java.util.function.Supplier;

public class GameViewManager {

    private PlacementCoordinateView view;

    private final ErrorReportView errorReportView;

    private final BoardView boardView;

    private Coordinate origin;

    public GameViewManager(BoardView boardView) {
        errorReportView = new ErrorReportView();
        this.boardView = boardView;
    }

    public void setPlacementCoordinateView(PlacementCoordinateView placementCoordinateView) {
        view = placementCoordinateView;
        if (origin != null) {
            view.setCoordinateOrigin(origin);
        }
    }

    public void remove(MoveController controller) {
        origin = getCoordinate(controller::validateOrigin, view::getCoordinate);
        controller.remove(origin);
    }

    public void put(MoveController controller) {
        Coordinate target;
        target = getCoordinate(coordinate -> controller.validateTarget(origin, coordinate), view::getCoordinate);
        controller.put(target);
    }

    public void put(PutController controller) {
        Coordinate target = getCoordinate(controller::validateTarget, view::getCoordinate);
        controller.put(target);
    }

    private Coordinate getCoordinate(Function<Coordinate, ErrorReport> errorReportCallback, Supplier<Coordinate> view) {
        Coordinate target = view.get();
        ErrorReport errorReport = errorReportCallback.apply(target);
        if (errorReport != null) {
            errorReportView.write(errorReport);
            target = getCoordinate(errorReportCallback, view);
        }
        return target;
    }

    public void nextToPlayer(PlacementController placementController) {
        if (!placementController.existTicTacToe()) {
            placementController.switchTurn();
        }
    }

    public void showGame(PlacementController placementController) {
        boardView.write(placementController);
        if (placementController.existTicTacToe()) {
            ColorView.instance().writeWinner(placementController.getTake());
            placementController.end();
        }
    }

    public void titleMovement(String title, Color color) {
        ColorView.instance().writeln(title + " el jugador ", color);
    }
}
