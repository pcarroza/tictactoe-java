package com.citadel.tictactoe.models.features.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameHistoryRegistry {

    private final Map<Integer, MoveHistory> histories;

    private int nextId;

    public GameHistoryRegistry() {
        this.histories = new LinkedHashMap<>();
        this.nextId = 1;
    }

    public void record(MoveHistory history) {
        histories.put(nextId++, history);
    }

    public List<MoveHistory> getAll() {
        return new ArrayList<>(histories.values());
    }

    public MoveHistory get(int index) {
        return getAll().get(index);
    }

    public int size() {
        return histories.size();
    }
}
