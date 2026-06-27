package main.controllers.features.game.errors;

import main.models.features.game.Game;

public class NotPropertyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new NotEmptyErrorReport(game.playerCoordinates());
    }
}
