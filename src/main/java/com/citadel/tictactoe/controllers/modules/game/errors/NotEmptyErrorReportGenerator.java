package com.citadel.tictactoe.controllers.modules.game.errors;

import com.citadel.tictactoe.models.modules.game.Game;

public class NotEmptyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new NotEmptyErrorReport(game.emptyCoordinates());
    }
}
