package com.citadel.tictactoe.models.persistence.repository.factory;

import com.citadel.tictactoe.models.persistence.repository.dao.GameDao;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;

public interface DaoFactory {

    GameDao createGameDao();

    StatisticsDao createStatisticsDao();
}
