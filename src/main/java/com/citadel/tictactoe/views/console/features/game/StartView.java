package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.StartController;
import com.citadel.tictactoe.controllers.features.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class StartView {

    private final BoardView boardView;

    private final ConsoleContext consoleContext;

    public StartView(BoardView boardView, ConsoleContext consoleContext) {
        this.boardView = boardView;
        this.consoleContext = consoleContext;
    }

    public void interact(StartController startController) {
        int users = consoleContext.limitedIntDialog().read("¿Cúantos Jugadores?", 0, 2);
        AiDifficulty difficulty = users < 2 ? readDifficulty() : AiDifficulty.EASY;
        startController.start(users, difficulty);
        boardView.write(startController);
    }

    private AiDifficulty readDifficulty() {
        boolean hard = consoleContext.yesNoDialog().read("¿IA en modo difícil?");
        return hard ? AiDifficulty.HARD : AiDifficulty.EASY;
    }
}
