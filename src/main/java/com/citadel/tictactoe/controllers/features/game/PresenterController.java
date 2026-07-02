package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;

public interface PresenterController {

    Player getColor(Coordinate coordinate);
}
