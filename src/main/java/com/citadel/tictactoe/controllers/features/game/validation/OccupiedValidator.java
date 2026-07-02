package com.citadel.tictactoe.controllers.features.game.validation;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public class OccupiedValidator extends AbstractCoordinateValidator {

    @Override
    protected ErrorReport check(Coordinate coordinate, Coordinate other, Game game) {
        if (!game.isEmpty(coordinate)) {
            return ErrorGeneratorType.NOT_EMPTY.getErrorReport(game);
        }
        return null;
    }
}
