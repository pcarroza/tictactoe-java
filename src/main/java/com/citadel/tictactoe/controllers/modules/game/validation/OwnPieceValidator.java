package com.citadel.tictactoe.controllers.modules.game.validation;

import com.citadel.tictactoe.controllers.modules.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;

public class OwnPieceValidator extends AbstractCoordinateValidator {

    @Override
    protected ErrorReport check(Coordinate coordinate, Coordinate other, Game game) {
        if (!game.isOccupiedByCurrentPlayer(coordinate)) {
            return ErrorGeneratorType.NOT_PROPERTY.getErrorReport(game);
        }
        return null;
    }
}
