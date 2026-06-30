package com.citadel.tictactoe.controllers.features.game.errors;

import com.citadel.tictactoe.models.features.game.Game;

public abstract class ErrorReportGenerator {
    public abstract ErrorReport getErrorReport(Game game);

}
