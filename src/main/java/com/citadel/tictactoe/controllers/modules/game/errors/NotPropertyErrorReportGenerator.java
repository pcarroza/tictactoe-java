package com.citadel.tictactoe.controllers.modules.game.errors;

import com.citadel.tictactoe.models.modules.game.Game;

public class NotPropertyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new NotPropertyErrorReport(game.playerCoordinates());
    }
}
