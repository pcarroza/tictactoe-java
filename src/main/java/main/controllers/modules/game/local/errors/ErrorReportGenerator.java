package main.controllers.modules.game.local.errors;

import main.models.Game;

public abstract class ErrorReportGenerator {
    public abstract ErrorReport getErrorReport(Game game);

}
