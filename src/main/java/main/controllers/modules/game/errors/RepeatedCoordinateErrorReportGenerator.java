package main.controllers.modules.game.errors;

import main.models.modules.game.Game;

public class RepeatedCoordinateErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new RepeatedCoordinateErrorReport(game.emptyCoordinates());
    }
}
