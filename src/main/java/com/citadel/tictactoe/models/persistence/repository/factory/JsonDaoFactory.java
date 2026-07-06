package com.citadel.tictactoe.models.persistence.repository.factory;

import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.JsonGameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.JsonStatisticsDao;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;

import java.nio.file.Path;

public class JsonDaoFactory implements DaoFactory {

    private static final Path ROOT = Path.of("data");

    @Override
    public GameDao createGameDao() {
        return new JsonGameDao(ROOT.resolve("games.json"));
    }

    @Override
    public StatisticsDao createStatisticsDao() {
        return new JsonStatisticsDao(ROOT.resolve("statistics.json"));
    }
}
