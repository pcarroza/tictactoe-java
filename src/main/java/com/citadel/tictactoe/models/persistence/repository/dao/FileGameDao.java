package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.models.persistence.entities.GameSnapshotEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileGameDao implements GameDao {

    private final Path file;

    public FileGameDao(Path file) {
        this.file = file;
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
        writeAll(new ArrayList<>(byId.values()));
    }

    @Override
    public List<GameSnapshot> findAll() {
        return readAll().stream().map(GameSnapshotMapper::toDomain).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private List<GameSnapshotEntity> readAll() {
        if (!Files.exists(file)) {
            return new ArrayList<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            return (List<GameSnapshotEntity>) in.readObject();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Formato de datos corrupto en " + file, e);
        }
    }

    private void writeAll(List<GameSnapshotEntity> entities) {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
                out.writeObject(entities);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
