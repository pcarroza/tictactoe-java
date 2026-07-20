package com.citadel.tictactoe.views.javafx.modules.game;

import com.citadel.tictactoe.controllers.modules.game.ContinueController;
import com.citadel.tictactoe.controllers.modules.game.GameOperationController;
import com.citadel.tictactoe.controllers.modules.game.Logic;
import com.citadel.tictactoe.controllers.modules.game.PlacementController;
import com.citadel.tictactoe.controllers.modules.game.RedoController;
import com.citadel.tictactoe.controllers.modules.game.SaveController;
import com.citadel.tictactoe.controllers.modules.game.StartController;
import com.citadel.tictactoe.controllers.modules.game.UndoController;
import com.citadel.tictactoe.views.core.GameView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxGameView implements GameView {

    private Logic logic;

    private Stage stage;

    public void bind(Logic logic, Stage stage) {
        this.logic = logic;
        this.stage = stage;
    }

    public void advance() {
        assert logic != null && stage != null;
        GameOperationController controller = logic.getController();
        if (controller == null) {
            Platform.exit();
            return;
        }
        interact(controller);
    }

    @Override
    public void interact(GameOperationController gameOperationController) {
        assert gameOperationController != null;
        gameOperationController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        new JavaFxStartView().interact(startController, stage, this::advance);
    }

    @Override
    public void visit(PlacementController placementController) {
        JavaFxBoardView boardView = new JavaFxBoardView();
        stage.setScene(new Scene(boardView.getRoot(), 600, 600));
        stage.setTitle("TicTacToe (JavaFX)");
        stage.show();
        new JavaFxPlacementView(boardView).interact(placementController, this::advance);
    }

    @Override
    public void visit(ContinueController continueController) {
        new JavaFxContinueView().interact(continueController, stage, this::advance);
    }

    @Override
    public void visit(SaveController saveController) {
        assert false;
    }

    @Override
    public void visit(UndoController undoController) {
        assert false;
    }

    @Override
    public void visit(RedoController redoController) {
        assert false;
    }
}
