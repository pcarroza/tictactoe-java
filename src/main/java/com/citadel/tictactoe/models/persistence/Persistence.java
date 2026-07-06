package com.citadel.tictactoe.models.persistence;

import com.citadel.tictactoe.models.persistence.repository.factory.DaoFactory;

public class Persistence {

    private static DaoFactory daoFactory;

    public static void configure(PersistenceType type) {
        daoFactory = type.createDaoFactory();
    }

    public static DaoFactory daoFactory() {
        return daoFactory;
    }
}
