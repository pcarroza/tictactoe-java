package com.citadel.tictactoe.models.features.game;

import com.citadel.tictactoe.models.persistence.Persistence;
import com.citadel.tictactoe.models.persistence.service.GameSnapshotService;

import java.util.List;

public class GameRegistry {

    private static final GameRegistry instance = new GameRegistry();

    private final GameSnapshotService service;

    private GameRegistry() {
        this.service = new GameSnapshotService(Persistence.daoFactory().createGameDao());
    }

    public static GameRegistry getInstance() {
        return instance;
    }

    public int nextId() {
        return service.nextId();
    }

    public void save(GameSnapshot snapshot) {
        service.save(snapshot);
    }

    public List<GameSnapshot> getAll() {
        return service.findAll();
    }

    public GameSnapshot get(int index) {
        return service.get(index);
    }

    public int size() {
        return service.size();
    }
}
