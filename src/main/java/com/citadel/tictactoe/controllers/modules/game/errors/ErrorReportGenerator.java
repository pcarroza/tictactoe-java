package com.citadel.tictactoe.controllers.modules.game.errors;

import com.citadel.tictactoe.models.modules.game.Game;

public abstract class ErrorReportGenerator {
    public abstract ErrorReport getErrorReport(Game game);

}
