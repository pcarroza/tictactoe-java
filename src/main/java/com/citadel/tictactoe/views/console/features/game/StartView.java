package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.StartController;
import com.citadel.tictactoe.shared.LimitedIntDialog;

public class StartView {

    private final BoardView boardView;

    public StartView(BoardView boardView) {
        this.boardView = boardView;
    }

    public void interact(StartController startController) {
        int users = LimitedIntDialog.instance().read("¿Cúantos Jugadores?", 0, 2);
        startController.start(users);
        boardView.write(startController);
    }
}
