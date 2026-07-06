package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.models.persistence.entities.GameSnapshotEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonGameDao implements GameDao {

    private static final Gson GSON = new Gson();

    private static final Type ENTITY_LIST_TYPE = new TypeToken<List<GameSnapshotEntity>>() {}.getType();

    private final Path file;

    public JsonGameDao(Path file) {
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

    private List<GameSnapshotEntity> readAll() {
        if (!Files.exists(file)) {
            return new ArrayList<>();
        }
        try (Reader reader = Files.newBufferedReader(file)) {
            List<GameSnapshotEntity> entities = GSON.fromJson(reader, ENTITY_LIST_TYPE);
            return entities != null ? entities : new ArrayList<>();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void writeAll(List<GameSnapshotEntity> entities) {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            try (Writer writer = Files.newBufferedWriter(file)) {
                GSON.toJson(entities, ENTITY_LIST_TYPE, writer);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
