package com.citadel.tictactoe.models.persistence.repository.dao;

import java.nio.file.Path;

public class FileGameDao extends AbstractGameFileDao {

    public FileGameDao(Path file) {
        super(file, new ObjectStreamCodec<>());
    }
}
