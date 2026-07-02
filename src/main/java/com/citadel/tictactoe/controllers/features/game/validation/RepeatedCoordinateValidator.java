package com.citadel.tictactoe.controllers.features.game.validation;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public class RepeatedCoordinateValidator extends AbstractCoordinateValidator {

    @Override
    protected ErrorReport check(Coordinate coordinate, Coordinate other, Game game) {
        if (other != null && other.equals(coordinate)) {
            return ErrorGeneratorType.REPEATED_COORDINATE.getErrorReport(game);
        }
        return null;
    }
}
