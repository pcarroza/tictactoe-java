package com.citadel.tictactoe.views.javafx.modules.game;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.UserCoordinateController;
import com.citadel.tictactoe.models.modules.game.Coordinate;

import java.util.function.Consumer;
import java.util.function.Function;

class JavaFxSimpleCoordinateRequest implements CoordinateControllerVisitor {

    private final JavaFxBoardView boardView;

    private final Function<CoordinateController, Coordinate> prefetch;

    private Coordinate coordinate;

    private Consumer<Coordinate> onChosen;

    JavaFxSimpleCoordinateRequest(JavaFxBoardView boardView, Function<CoordinateController, Coordinate> prefetch) {
        this.boardView = boardView;
        this.prefetch = prefetch;
    }

    void request(CoordinateController coordinateController, Consumer<Coordinate> onChosen) {
        this.coordinate = prefetch.apply(coordinateController);
        this.onChosen = onChosen;
        coordinateController.accept(this);
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        boardView.setInteractive(true);
        boardView.onCellClick(clicked -> {
            boardView.setInteractive(false);
            coordinate.setRow(clicked.getRow());
            coordinate.setColumn(clicked.getColumn());
            onChosen.accept(coordinate);
        });
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        boardView.showStatus("La máquina elige " + coordinate);
        onChosen.accept(coordinate);
    }
}
