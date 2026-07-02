package com.citadel.tictactoe.controllers.features.replay;

import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;

public interface ReplayController {

    void accept(ReplayControllerVisitor visitor);

    Player getColor(Coordinate coordiante);

    int getPosition();

    int getTotal();

    boolean hasNext();

    boolean hasPrevious();

    void next();

    void previous();

    void exit();
}
