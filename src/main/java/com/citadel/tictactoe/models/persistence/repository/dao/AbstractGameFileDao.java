package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.persistence.entities.GameSnapshotEntity;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class AbstractGameFileDao extends AbstractFileDao<List<GameSnapshotEntity>> implements GameDao {

    AbstractGameFileDao(Path file, FileCodec<List<GameSnapshotEntity>> codec) {
        super(file, codec);
    }

    @Override
    public int nextId() {
        return readAll().stream().mapToInt(GameSnapshotEntity::gameId).max().orElse(0) + 1;
    }

    @Override
    public void save(GameSnapshot snapshot) {
        Map<Integer, GameSnapshotEntity> byId = new LinkedHashMap<>();
        readAll().forEach(entity -> byId.put(entity.gameId(), entity));
        byId.put(snapshot.gameId(), GameSnapshotMapper.toEntity(snapshot));
        write(new ArrayList<>(byId.values()));
    }

    @Override
    public List<GameSnapshot> findAll() {
        return readAll().stream().map(GameSnapshotMapper::toDomain).collect(Collectors.toList());
    }

    private List<GameSnapshotEntity> readAll() {
        return readOrDefault(new ArrayList<>());
    }
}
