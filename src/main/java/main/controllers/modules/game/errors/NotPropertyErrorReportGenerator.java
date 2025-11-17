package main.controllers.modules.game.errors;

import main.models.modules.game.Game;

public class NotPropertyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new NotEmptyErrorReport(game.playerCoordinates());
    }
}
