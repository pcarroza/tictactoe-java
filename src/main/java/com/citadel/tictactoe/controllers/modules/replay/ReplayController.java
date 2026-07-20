package com.citadel.tictactoe.controllers.modules.replay;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Player;

public interface ReplayController {

    Player getColor(Coordinate coordiante);

    int getPosition();

    int getTotal();

    boolean hasNext();

    boolean hasPrevious();

    void next();

    void previous();

    void exit();

    void accept(ReplayControllerVisitor visitor);
}
