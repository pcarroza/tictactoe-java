package main.controllers.features.game;

import main.models.features.game.Player;
import main.models.features.game.Coordinate;

public interface PresenterController {

    Player getColor(Coordinate coordinate);
}
