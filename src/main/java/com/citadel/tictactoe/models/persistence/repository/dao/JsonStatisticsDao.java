package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

import java.nio.file.Path;

public class JsonStatisticsDao extends AbstractStatisticsFileDao {

    public JsonStatisticsDao(Path file) {
        super(file, new GsonCodec<>(StatisticsDto.class));
    }
}
