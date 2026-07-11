package com.citadel.tictactoe.controllers.features.load.local;

import com.citadel.tictactoe.controllers.features.load.LoadController;
import com.citadel.tictactoe.controllers.features.load.LoadControllerVisitor;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.game.GameSnapshot;

import java.util.ArrayList;
import java.util.List;

public class LocalLoadController implements LoadController {

    private final GameRegistry gameRegistry;

    private GameSnapshot selected;

    public LocalLoadController(GameRegistry gameRegistry) {
        this.gameRegistry = gameRegistry;
    }

    @Override
    public boolean hasGames() {
        return gameRegistry.size() > 0;
    }

    @Override
    public List<String> getGameTitles() {
        List<String> titles = new ArrayList<>();
        for (GameSnapshot snapshot : gameRegistry.getAll()) {
            titles.add("Partida #" + snapshot.gameId());
        }
        return titles;
    }

    @Override
    public void select(int index) {
        this.selected = gameRegistry.get(index);
    }

    @Override
    public GameSnapshot getSelected() {
        return selected;
    }

    @Override
    public void accept(LoadControllerVisitor visitor) {
        visitor.visit(this);
    }
}
