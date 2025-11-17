package main.controllers.modules.game;

import main.models.modules.game.Player;
import main.models.modules.game.Coordinate;

public interface PresenterController {

    Player getColor(Coordinate coordinate);
}
