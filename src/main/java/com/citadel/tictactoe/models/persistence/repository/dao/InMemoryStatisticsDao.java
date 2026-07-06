package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

import java.util.Optional;

public class InMemoryStatisticsDao implements StatisticsDao {

    private StatisticsDto current;

    @Override
    public Optional<StatisticsDto> load() {
        return Optional.ofNullable(current);
    }

    @Override
    public void save(StatisticsDto dto) {
        current = dto;
    }
}
