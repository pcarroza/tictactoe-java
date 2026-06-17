package main.core.commands;

import main.core.enums.CommandTitle;
import main.core.logics.game.GameLogic;
import main.views.console.core.Command;

public class StartGameCommand extends Command {

    private final GameLogic gameLogic;

    public StartGameCommand(GameLogic gameLogic) {
        super(CommandTitle.START_GAME.getTitle());
        this.gameLogic = gameLogic;
    }

    @Override
    public void execute() {
        this.gameLogic.run();
    }
}
