package main.views.console;

import main.controllers.StartController;
import main.common.utils.LimitedIntDialog;
import main.common.constants.Constants;

public class StartView {

    private final BoardView boardView;

    StartView(BoardView boardView) {
        this.boardView = boardView;
    }

    void interact(StartController startController) {
        int users = LimitedIntDialog.instance().read("¿Cúantos Jugadores?", Constants.MIN, Constants.MAX);
        startController.start(users);
        boardView.write(startController);
    }
}
