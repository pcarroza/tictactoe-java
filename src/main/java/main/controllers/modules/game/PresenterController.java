package main.controllers.modules.game;

import main.models.Player;
import main.models.Coordinate;

public interface PresenterController {

    Player getColor(Coordinate coordinate);
}
