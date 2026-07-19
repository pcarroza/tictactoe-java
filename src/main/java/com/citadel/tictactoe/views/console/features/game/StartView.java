package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.StartController;
import com.citadel.tictactoe.controllers.features.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.YesNoDialog;

public class StartView {

    private final BoardView boardView;

    public StartView(BoardView boardView) {
        this.boardView = boardView;
    }

    public void interact(StartController startController) {
        int users = new LimitedIntDialog().read("¿Cúantos Jugadores?", 0, 2);
        AiDifficulty difficulty = users < 2 ? readDifficulty() : AiDifficulty.EASY;
        startController.start(users, difficulty);
        boardView.write(startController);
    }

    private AiDifficulty readDifficulty() {
        boolean hard = new YesNoDialog().read("¿IA en modo difícil?");
        return hard ? AiDifficulty.HARD : AiDifficulty.EASY;
    }
}
