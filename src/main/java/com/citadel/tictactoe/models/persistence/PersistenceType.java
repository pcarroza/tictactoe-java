package com.citadel.tictactoe.models.persistence;

import com.citadel.tictactoe.models.persistence.repository.factory.DaoFactory;
import com.citadel.tictactoe.models.persistence.repository.factory.FileDaoFactory;
import com.citadel.tictactoe.models.persistence.repository.factory.InMemoryDaoFactory;
import com.citadel.tictactoe.models.persistence.repository.factory.JsonDaoFactory;
import com.citadel.tictactoe.models.persistence.repository.factory.SqliteDaoFactory;

public enum PersistenceType {

    IN_MEMORY {
        @Override
        public DaoFactory createDaoFactory() {
            return new InMemoryDaoFactory();
        }
    },

    FILE {
        @Override
        public DaoFactory createDaoFactory() {
            return new FileDaoFactory();
        }
    },

    JSON {
        @Override
        public DaoFactory createDaoFactory() {
            return new JsonDaoFactory();
        }
    },

    SQLITE {
        @Override
        public DaoFactory createDaoFactory() {
            return new SqliteDaoFactory();
        }
    };

    public abstract DaoFactory createDaoFactory();
}
