package com.citadel.tictactoe.models.persistence.service;

import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;

import java.util.List;

public class GameSnapshotService {

    private final GameDao gameDao;

    public GameSnapshotService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public int nextId() {
        return gameDao.nextId();
    }

    public void save(GameSnapshot gameSnapshot) {
        gameDao.save(gameSnapshot);
    }

    public List<GameSnapshot> findAll() {
        return gameDao.findAll();
    }

    public GameSnapshot get(int index) {
        return findAll().get(index);
    }

    public int size() {
        return findAll().size();
    }
}
