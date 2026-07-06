package com.citadel.tictactoe.models.persistence.repository.dao;

import java.sql.SQLException;

public class UncheckedSqlException extends RuntimeException {

    public UncheckedSqlException(SQLException cause) {
        super(cause);
    }

    public UncheckedSqlException(String message, SQLException cause) {
        super(message, cause);
    }
}
