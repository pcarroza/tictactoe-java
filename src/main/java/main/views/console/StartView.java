package main.views.console;

import main.controllers.StartController;
import main.utils.LimitedIntDialog;

public class StartView {

    private final BoardView boardView;

    StartView(BoardView boardView) {
        this.boardView = boardView;
    }

    void interact(StartController startController) {
        int users = LimitedIntDialog.instance().read("¿Cúantos Jugadores?", 0, 2);
        startController.start(users);
        this.boardView.write(startController);
    }
}
