package com.citadel.tictactoe.controllers.features.game.validation;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public class OwnPieceValidator extends AbstractCoordinateValidator {

    @Override
    protected ErrorReport check(Coordinate coordinate, Coordinate other, Game game) {
        if (!game.isOccupiedByCurrentPlayer(coordinate)) {
            return ErrorGeneratorType.NOT_PROPERTY.getErrorReport(game);
        }
        return null;
    }
}
