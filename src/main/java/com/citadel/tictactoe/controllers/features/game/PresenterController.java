package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.game.Coordinate;

public interface PresenterController {

    Player getColor(Coordinate coordinate);
}
