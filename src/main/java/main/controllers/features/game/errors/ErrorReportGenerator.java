package main.controllers.features.game.errors;

import main.models.features.game.Game;

public abstract class ErrorReportGenerator {
    public abstract ErrorReport getErrorReport(Game game);

}
