package com.citadel.tictactoe.controllers.features.game.validation;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public abstract class AbstractCoordinateValidator implements CoordinateValidator {

    private CoordinateValidator next;

    @Override
    public void setNext(CoordinateValidator next) {
        this.next = next;
    }

    @Override
    public ErrorReport validate(Coordinate coordinate, Coordinate other, Game game) {
        ErrorReport report = check(coordinate, other, game);
        if (report != null) {
            return report;
        }
        return next != null ? next.validate(coordinate, other, game) : null;
    }

    protected abstract ErrorReport check(Coordinate coordinate, Coordinate other, Game game);
}
