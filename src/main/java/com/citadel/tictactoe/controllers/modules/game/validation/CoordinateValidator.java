package com.citadel.tictactoe.controllers.modules.game.validation;

import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;

public interface CoordinateValidator {

    ErrorReport validate(Coordinate coordinate, Coordinate other, Game game);

    void setNext(CoordinateValidator next);
}
