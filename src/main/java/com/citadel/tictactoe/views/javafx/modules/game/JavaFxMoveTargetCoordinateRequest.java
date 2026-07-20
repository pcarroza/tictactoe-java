package com.citadel.tictactoe.views.javafx.modules.game;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.UserCoordinateController;
import com.citadel.tictactoe.models.modules.game.Coordinate;

import java.util.function.Consumer;

class JavaFxMoveTargetCoordinateRequest implements CoordinateControllerVisitor {

    private final JavaFxBoardView boardView;

    private final Coordinate origin;

    private Coordinate target;

    private Consumer<Coordinate> onChosen;

    JavaFxMoveTargetCoordinateRequest(JavaFxBoardView boardView, Coordinate origin) {
        this.boardView = boardView;
        this.origin = origin;
    }

    void request(CoordinateController coordinateController, Consumer<Coordinate> onChosen) {
        this.onChosen = onChosen;
        coordinateController.accept(this);
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        target = userCoordinateController.getTarget();
        boardView.setInteractive(true);
        boardView.onCellClick(clicked -> {
            boardView.setInteractive(false);
            target.setRow(clicked.getRow());
            target.setColumn(clicked.getColumn());
            onChosen.accept(target);
        });
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        target = machineCoordinateController.getTarget(origin);
        boardView.showStatus("La máquina mueve a " + target);
        onChosen.accept(target);
    }
}
