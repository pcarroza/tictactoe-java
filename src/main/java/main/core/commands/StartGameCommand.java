package main.core.commands;

import main.core.logics.game.GameLogic;
import main.views.console.core.Command;

public class StartGameCommand extends Command {

    private final GameLogic gameLogic;

    public StartGameCommand(GameLogic gameLogic) {
        super("Iniciar Juego");
        this.gameLogic = gameLogic;
    }

    @Override
    public void execute() {
        this.gameLogic.run();
    }
}
