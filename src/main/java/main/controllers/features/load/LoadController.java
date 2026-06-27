package main.controllers.features.load;

import main.models.features.game.GameSnapshot;

import java.util.List;

public interface LoadController {

    boolean hasGames();

    List<String> getGameTitles();

    void select(int index);

    GameSnapshot getSelected();

    void accept(LoadControllerVisitor visitor);
}
