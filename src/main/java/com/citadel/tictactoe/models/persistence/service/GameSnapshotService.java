package com.citadel.tictactoe.models.persistence.service;

import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;

import java.util.List;

public class GameSnapshotService {

    private final GameDao dao;

    public GameSnapshotService(GameDao dao) {
        this.dao = dao;
    }

    public int nextId() {
        return dao.nextId();
    }

    public void save(GameSnapshot snapshot) {
        dao.save(snapshot);
    }

    public List<GameSnapshot> findAll() {
        return dao.findAll();
    }

    public GameSnapshot get(int index) {
        return findAll().get(index);
    }

    public int size() {
        return findAll().size();
    }
}
