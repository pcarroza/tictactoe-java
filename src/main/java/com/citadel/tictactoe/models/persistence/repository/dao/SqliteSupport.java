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

    static <T> T withConnection(Path file, SqlFunction<T> action) {
        Connection connection = open(file);
        try {
            return action.apply(connection);
        } catch (SQLException e) {
            throw new UncheckedSqlException(e);
        } finally {
            closeQuietly(connection);
        }
    }

    static void inTransaction(Path file, SqlAction action) {
        withConnection(file, connection -> {
            connection.setAutoCommit(false);
            try {
                action.run(connection);
                connection.commit();
                return null;
            } catch (SQLException e) {
                rollback(connection, e);
                throw e;
            }
        });
    }

    private static void rollback(Connection connection, SQLException original) {
        try {
            connection.rollback();
        } catch (SQLException suppressed) {
            original.addSuppressed(suppressed);
        }
    }

    private static void closeQuietly(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new UncheckedSqlException(e);
        }
    }

    @FunctionalInterface
    interface SqlFunction<T> {

        T apply(Connection connection) throws SQLException;
    }

    @FunctionalInterface
    interface SqlAction {

        void run(Connection connection) throws SQLException;
    }
}
