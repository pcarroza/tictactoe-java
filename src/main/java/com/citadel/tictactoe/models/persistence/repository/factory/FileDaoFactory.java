package com.citadel.tictactoe.models.persistence.repository.factory;

import com.citadel.tictactoe.models.persistence.repository.dao.FileGameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.FileStatisticsDao;
import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;

import java.nio.file.Path;

public class FileDaoFactory implements DaoFactory {

    private static final Path ROOT = Path.of("data");

    @Override
    public GameDao createGameDao() {
        return new FileGameDao(ROOT.resolve("games.ser"));
    }

    @Override
    public StatisticsDao createStatisticsDao() {
        return new FileStatisticsDao(ROOT.resolve("statistics.ser"));
    }
}
