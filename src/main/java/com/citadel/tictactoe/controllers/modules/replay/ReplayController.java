package com.citadel.tictactoe.controllers.modules.replay;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Player;

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
