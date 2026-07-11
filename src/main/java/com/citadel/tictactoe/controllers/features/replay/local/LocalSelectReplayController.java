package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.controllers.features.replay.SelectReplayController;
import com.citadel.tictactoe.controllers.features.replay.SelectReplayControllerVisitor;
import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.features.game.MoveHistory;

import java.util.ArrayList;
import java.util.List;

public class LocalSelectReplayController implements SelectReplayController {

    private final GameHistoryRegistry gameHistoryRegistry;

    private MoveHistory selected;

    public LocalSelectReplayController(GameHistoryRegistry gameHistoryRegistry) {
        this.gameHistoryRegistry = gameHistoryRegistry;
    }

    @Override
    public boolean hasGames() {
        return gameHistoryRegistry.size() > 0;
    }

    @Override
    public List<String> getGameTitles() {
        List<String> titles = new ArrayList<>();
        List<MoveHistory> histories = gameHistoryRegistry.getAll();
        for (int i = 0; i < histories.size(); i++) {
            titles.add("Partida #" + (i + 1));
        }
        return titles;
    }

    @Override
    public void select(int index) {
        this.selected = gameHistoryRegistry.get(index);
    }

    @Override
    public MoveHistory getSelected() {
        return selected;
    }

    @Override
    public void accept(SelectReplayControllerVisitor visitor) {
        visitor.visit(this);
    }
}
