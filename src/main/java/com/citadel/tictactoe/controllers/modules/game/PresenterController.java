package com.citadel.tictactoe.controllers.modules.game;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Player;

public interface PresenterController {

    Player getColor(Coordinate coordinate);
}
