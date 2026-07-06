package com.citadel.tictactoe.models.persistence.repository.dao;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class SqliteSupport {

    private SqliteSupport() {
    }

    static Connection open(Path file) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + file);
            try (Statement statement = connection.createStatement()) {
                statement.execute("PRAGMA foreign_keys = ON;");
            }
            return connection;
        } catch (SQLException e) {
            throw new UncheckedSqlException(e);
        }
    }
}
