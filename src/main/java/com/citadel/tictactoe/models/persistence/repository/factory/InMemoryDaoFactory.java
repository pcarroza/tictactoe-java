package com.citadel.tictactoe.models.persistence.repository.factory;

import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.InMemoryGameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.InMemoryStatisticsDao;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;

public class InMemoryDaoFactory implements DaoFactory {

    @Override
    public GameDao createGameDao() {
        return new InMemoryGameDao();
    }

    @Override
    public StatisticsDao createStatisticsDao() {
        return new InMemoryStatisticsDao();
    }
}
