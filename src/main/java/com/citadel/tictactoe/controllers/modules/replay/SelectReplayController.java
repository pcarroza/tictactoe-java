package com.citadel.tictactoe.controllers.modules.replay;

import com.citadel.tictactoe.models.modules.game.MoveHistory;

import java.util.List;

public interface SelectReplayController {

    boolean hasGames();

    List<String> getGameTitles();

    void select(int index);

    MoveHistory getSelected();

    void accept(SelectReplayControllerVisitor visitor);
}
