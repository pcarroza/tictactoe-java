package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.MoveController;
import com.citadel.tictactoe.controllers.features.game.PlacementController;
import com.citadel.tictactoe.controllers.features.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PutController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

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
        if (placementController.canUndo()) terminal.writeln("  [3] Deshacer movimiento");
        if (placementController.canRedo()) terminal.writeln("  [4] Rehacer movimiento");
        terminal.writeln("  [5] Salir");
        terminal.writeln();
        int option = LimitedIntDialog.instance().read("  Selecciona una opción", 5);
        if (option == 1) {
            placementController.accept(this);
        } else if (option == 2) {
            placementController.save();
        } else if (option == 3 && placementController.canUndo()) {
            placementController.undo();
        } else if (option == 4 && placementController.canRedo()) {
            placementController.redo();
        } else if (option == 5) {
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
