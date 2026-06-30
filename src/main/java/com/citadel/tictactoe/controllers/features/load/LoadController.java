package com.citadel.tictactoe.controllers.features.load;

import com.citadel.tictactoe.models.features.game.GameSnapshot;

import java.util.List;

public interface LoadController {

    boolean hasGames();

    List<String> getGameTitles();

    void select(int index);

    GameSnapshot getSelected();

    void accept(LoadControllerVisitor visitor);
}
