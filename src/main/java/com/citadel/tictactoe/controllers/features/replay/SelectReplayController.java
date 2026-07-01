package com.citadel.tictactoe.controllers.features.replay;

import com.citadel.tictactoe.models.features.game.MoveHistory;

import java.util.List;

public interface SelectReplayController {

    boolean hasGames();

    List<String> getGameTitles();

    void select(int index);

    MoveHistory getSelected();

    void accept(SelectReplayControllerVisitor visitor);
}
