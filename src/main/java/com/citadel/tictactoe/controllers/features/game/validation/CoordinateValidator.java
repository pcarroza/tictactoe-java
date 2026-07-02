package com.citadel.tictactoe.controllers.features.game.validation;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public interface CoordinateValidator {

    ErrorReport validate(Coordinate coordinate, Coordinate other, Game game);

    void setNext(CoordinateValidator next);
}
