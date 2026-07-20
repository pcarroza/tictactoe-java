package com.citadel.tictactoe.views.javafx.modules.game;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.MoveController;
import com.citadel.tictactoe.controllers.modules.game.PlacementController;
import com.citadel.tictactoe.controllers.modules.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PutController;
import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.models.modules.game.Coordinate;

class JavaFxPlacementView implements PlacementControllerVisitor {

    private final JavaFxBoardView boardView;

    private Runnable onDone;

    JavaFxPlacementView(JavaFxBoardView boardView) {
        this.boardView = boardView;
    }

    void interact(PlacementController placementController, Runnable onDone) {
        this.onDone = onDone;
        boardView.render(placementController);
        boardView.showStatus(placementController.take() + " juega");
        placementController.accept(this);
    }

    @Override
    public void visit(PutController putController) {
        new JavaFxSimpleCoordinateRequest(boardView, CoordinateController::getTarget)
                .request(putController.getCoordinateController(), target -> tryPut(putController, target));
    }

    private void tryPut(PutController putController, Coordinate target) {
        ErrorReport error = putController.validateTarget(target);
        if (error != null) {
            boardView.showStatus(JavaFxErrorMessages.of(error));
            visit(putController);
            return;
        }
        putController.put(target);
        finishTurn(putController);
    }

    @Override
    public void visit(MoveController moveController) {
        new JavaFxSimpleCoordinateRequest(boardView, CoordinateController::getOrigin)
                .request(moveController.getCoordinateController(), origin -> tryOrigin(moveController, origin));
    }

    private void tryOrigin(MoveController moveController, Coordinate origin) {
        ErrorReport error = moveController.validateOrigin(origin);
        if (error != null) {
            boardView.showStatus(JavaFxErrorMessages.of(error));
            visit(moveController);
            return;
        }
        requestMoveTarget(moveController, origin);
    }

    private void requestMoveTarget(MoveController moveController, Coordinate origin) {
        new JavaFxMoveTargetCoordinateRequest(boardView, origin).request(
                moveController.getCoordinateController(),
                target -> tryMoveTarget(moveController, origin, target));
    }

    private void tryMoveTarget(MoveController moveController, Coordinate origin, Coordinate target) {
        ErrorReport error = moveController.validateTarget(origin, target);
        if (error != null) {
            boardView.showStatus(JavaFxErrorMessages.of(error));
            requestMoveTarget(moveController, origin);
            return;
        }
        moveController.remove(origin);
        moveController.put(target);
        finishTurn(moveController);
    }

    private void finishTurn(PlacementController placementController) {
        if (!placementController.existTicTacToe()) {
            placementController.changeTurn();
        }
        boardView.render(placementController);
        if (placementController.existTicTacToe()) {
            boardView.showStatus("¡Victoria de " + placementController.take() + "!");
            placementController.end();
        }
        onDone.run();
    }
}
