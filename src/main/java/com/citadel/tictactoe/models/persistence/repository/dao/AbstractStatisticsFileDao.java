package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

import java.nio.file.Path;
import java.util.Optional;

abstract class AbstractStatisticsFileDao extends AbstractFileDao<StatisticsDto> implements StatisticsDao {

    AbstractStatisticsFileDao(Path file, FileCodec<StatisticsDto> codec) {
        super(file, codec);
    }

    @Override
    public Optional<StatisticsDto> load() {
        return Optional.ofNullable(readOrDefault(null));
    }

    @Override
    public void save(StatisticsDto dto) {
        write(dto);
    }
}
