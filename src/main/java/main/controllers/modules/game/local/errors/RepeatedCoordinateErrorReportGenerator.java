package main.controllers.modules.game.local.errors;

import main.models.Game;

public class RepeatedCoordinateErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new RepeatedCoordinateErrorReport(game.emptyCoordinates());
    }
}
