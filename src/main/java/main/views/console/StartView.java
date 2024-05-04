package main.views.console;

import main.controllers.StartController;
import main.utils.LimitedIntDialog;
import main.utils.constants.Constants;

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
