package com.citadel.tictactoe.models.persistence.repository.factory;

import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.SqliteGameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.SqliteStatisticsDao;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;

import java.nio.file.Path;

public class SqliteDaoFactory implements DaoFactory {

    private static final Path ROOT = Path.of("data");

    private static final Path DB_FILE = ROOT.resolve("tictactoe.db");

    @Override
    public GameDao createGameDao() {
        return new SqliteGameDao(DB_FILE);
    }

    @Override
    public StatisticsDao createStatisticsDao() {
        return new SqliteStatisticsDao(DB_FILE);
    }
}
