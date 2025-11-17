package main.controllers.modules.game.errors;

import main.models.modules.game.Game;

public abstract class ErrorReportGenerator {

    public abstract ErrorReport getErrorReport(Game game);
}
