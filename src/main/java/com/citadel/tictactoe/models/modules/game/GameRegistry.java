package com.citadel.tictactoe.models.modules.game;

import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;
import com.citadel.tictactoe.models.persistence.service.GameSnapshotService;

import java.util.List;

public class GameRegistry {

    private final GameSnapshotService service;

    public GameRegistry(GameDao gameDao) {
        this.service = new GameSnapshotService(gameDao);
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
