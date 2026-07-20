package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.modules.game.GameSnapshot;

import java.util.List;

public interface GameDao {

    int nextId();

    void save(GameSnapshot snapshot);

    List<GameSnapshot> findAll();
}
