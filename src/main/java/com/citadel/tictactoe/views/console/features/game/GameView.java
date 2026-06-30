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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class GameView implements PlacementControllerVisitor {

    private final ErrorReportView errorReportView;

    private final BoardView boardView;

    private final HistoryView historyView;

    private Coordinate origin;

    public GameView(BoardView boardView) {
        assert boardView != null;
        this.boardView = boardView;
        errorReportView = new ErrorReportView();
        historyView = new HistoryView();
    }

    public void interact(PlacementController placementController) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        boardView.write(placementController);
        terminal.writeln();
        List<Runnable> options = buildOptions(placementController);
        terminal.writeln();
        int choice = LimitedIntDialog.instance().read("  Selecciona una opción", options.size());
        options.get(choice - 1).run();
    }

    private List<Runnable> buildOptions(PlacementController controller) {
        List<Runnable> options = new ArrayList<>();
        Terminal terminal = Terminal.getInstance();
        addOption(terminal, options, "Jugar turno", () -> controller.accept(this));
        addOption(terminal, options, "Guardar partida", controller::save);
        if (controller.canUndo()) {
            addOption(terminal, options, "Deshacer movimiento", controller::undo);
        }
        if (controller.canRedo()) {
            addOption(terminal, options, "Rehacer movimiento", controller::redo);
        }
        addOption(terminal, options, "Ver historial", () -> historyView.show(controller.getMoveHistory()));
        addOption(terminal, options, "Salir", controller::exit);
        return options;
    }

    private void addOption(Terminal terminal, List<Runnable> options, String label, Runnable action) {
        options.add(action);
        terminal.writeln("  [" + options.size() + "] " + label);
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
