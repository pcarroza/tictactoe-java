package com.citadel.tictactoe.models.persistence.repository.dao;

import java.nio.file.Path;

public class FileStatisticsDao extends AbstractStatisticsFileDao {

    public FileStatisticsDao(Path file) {
        super(file, new ObjectStreamCodec<>());
    }
}
