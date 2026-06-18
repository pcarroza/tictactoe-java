package main.core.commands;

import main.core.enums.Title;
import main.core.logics.game.GameLogic;
import main.views.console.core.Command;

public class StartGameCommand extends Command {

    private final GameLogic gameLogic;

    public StartGameCommand(GameLogic gameLogic) {
        super(Title.START_GAME.getTitle());
        this.gameLogic = gameLogic;
    }

    @Override
    public void execute() {
        this.gameLogic.run();
    }
}
