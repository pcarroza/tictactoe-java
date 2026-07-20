package com.citadel.tictactoe.controllers.modules.game.local.logic;

import com.citadel.tictactoe.controllers.modules.game.ContinueController;
import com.citadel.tictactoe.controllers.modules.game.GameOperationController;
import com.citadel.tictactoe.controllers.modules.game.MoveController;
import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PlacementController;
import com.citadel.tictactoe.controllers.modules.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PutController;
import com.citadel.tictactoe.controllers.modules.game.RedoController;
import com.citadel.tictactoe.controllers.modules.game.SaveController;
import com.citadel.tictactoe.controllers.modules.game.StartController;
import com.citadel.tictactoe.controllers.modules.game.UndoController;
import com.citadel.tictactoe.controllers.modules.game.local.TimedPlacementController;

import java.time.Duration;

public class TimedControllerFactory implements OperationControllerVisitor, PlacementControllerVisitor {

    private static final Duration TURN_LIMIT = Duration.ofSeconds(15);

    private GameOperationController result;

    static GameOperationController wrap(GameOperationController controller) {
        if (controller == null) {
            return null;
        }
        TimedControllerFactory factory = new TimedControllerFactory();
        controller.accept(factory);
        return factory.result;
    }

    @Override
    public void visit(StartController startController) {
        result = startController;
    }

    @Override
    public void visit(PlacementController placementController) {
        placementController.accept((PlacementControllerVisitor) this);
    }

    @Override
    public void visit(ContinueController continueController) {
        result = continueController;
    }

    @Override
    public void visit(SaveController saveController) {
        result = saveController;
    }

    @Override
    public void visit(UndoController undoController) {
        result = undoController;
    }

    @Override
    public void visit(RedoController redoController) {
        result = redoController;
    }

    @Override
    public void visit(PutController putController) {
        result = new TimedPlacementController(putController, TURN_LIMIT);
    }

    @Override
    public void visit(MoveController moveController) {
        result = moveController;
    }
}
