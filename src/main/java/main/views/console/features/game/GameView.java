package main.views.console.features.game;

import main.controllers.features.game.MoveController;
import main.controllers.features.game.PlacementController;
import main.controllers.features.game.PlacementControllerVisitor;
import main.controllers.features.game.PutController;
import main.controllers.features.game.errors.ErrorReport;
import main.models.features.game.Player;
import main.models.features.game.Coordinate;
import main.shared.LimitedIntDialog;
import main.shared.Terminal;

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
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        boardView.write(placementController);
        terminal.writeln();
        terminal.writeln("  [1] Jugar turno");
        terminal.writeln("  [2] Guardar partida");
        terminal.writeln("  [3] Salir");
        terminal.writeln();
        int option = LimitedIntDialog.instance().read("  Selecciona una opción", 3);
        if (option == 1) {
            placementController.accept(this);
        } else if (option == 2) {
            placementController.save();
        } else {
            placementController.exit();
        }
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
        Terminal.getInstance().clear();
        boardView.write(placementController);
        if (placementController.existTicTacToe()) {
            ColorView.instance().writeWinner(placementController.take());
            placementController.end();
        }
    }
}
