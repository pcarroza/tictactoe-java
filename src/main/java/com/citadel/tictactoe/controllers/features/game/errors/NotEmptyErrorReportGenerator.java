package com.citadel.tictactoe.controllers.features.game.errors;

import com.citadel.tictactoe.models.features.game.Game;

public class NotEmptyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new RepeatedCoordinateErrorReport(game.emptyCoordinates());
    }
}
