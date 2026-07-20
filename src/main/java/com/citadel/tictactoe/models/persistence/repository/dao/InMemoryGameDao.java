package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.modules.game.GameSnapshot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryGameDao implements GameDao {

    private final Map<Integer, GameSnapshot> snapshots = new LinkedHashMap<>();

    private int nextId = 1;

    @Override
    public int nextId() {
        return nextId++;
    }

    @Override
    public void save(GameSnapshot snapshot) {
        snapshots.put(snapshot.gameId(), snapshot);
    }

    @Override
    public List<GameSnapshot> findAll() {
        return new ArrayList<>(snapshots.values());
    }
}
