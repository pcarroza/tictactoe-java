package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

import java.util.Optional;

public interface StatisticsDao {

    Optional<StatisticsDto> load();

    void save(StatisticsDto dto);
}
