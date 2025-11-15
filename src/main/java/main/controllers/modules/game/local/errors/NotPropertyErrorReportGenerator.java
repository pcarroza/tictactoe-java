package main.controllers.modules.game.local.errors;

import main.models.Game;

public class NotPropertyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new NotEmptyErrorReport(game.playerCoordinates());
    }
}
