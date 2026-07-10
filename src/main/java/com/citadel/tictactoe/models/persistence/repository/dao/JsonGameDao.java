package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.entities.GameSnapshotEntity;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.List;

public class JsonGameDao extends AbstractGameFileDao {

    private static final Type ENTITY_LIST_TYPE = new TypeToken<List<GameSnapshotEntity>>() {}.getType();

    public JsonGameDao(Path file) {
        super(file, new GsonCodec<>(ENTITY_LIST_TYPE));
    }
}
