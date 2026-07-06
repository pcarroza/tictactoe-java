package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class SqliteStatisticsDao implements StatisticsDao {

    private final Path file;

    public SqliteStatisticsDao(Path file) {
        this.file = file;
        createDirectory();
        createSchema();
    }

    @Override
    public Optional<StatisticsDto> load() {
        Connection connection = SqliteSupport.open(file);
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT player, wins FROM statistics")) {
            Map<Player, Integer> wins = new EnumMap<>(Player.class);
            while (resultSet.next()) {
                wins.put(Player.valueOf(resultSet.getString("player")), resultSet.getInt("wins"));
            }
            return wins.isEmpty() ? Optional.empty() : Optional.of(new StatisticsDto(wins));
        } catch (SQLException e) {
            throw new UncheckedSqlException(e);
        } finally {
            closeQuietly(connection);
        }
    }

    @Override
    public void save(StatisticsDto dto) {
        Connection connection = SqliteSupport.open(file);
        try {
            connection.setAutoCommit(false);
            clear(connection);
            insertAll(connection, dto);
            connection.commit();
        } catch (SQLException e) {
            rollback(connection, e);
            throw new UncheckedSqlException(e);
        } finally {
            closeQuietly(connection);
        }
    }

    private void createDirectory() {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void createSchema() {
        Connection connection = SqliteSupport.open(file);
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS statistics (" +
                    "player TEXT PRIMARY KEY, " +
                    "wins INTEGER NOT NULL)");
        } catch (SQLException e) {
            throw new UncheckedSqlException(e);
        } finally {
            closeQuietly(connection);
        }
    }

    private void clear(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM statistics");
        }
    }

    private void insertAll(Connection connection, StatisticsDto dto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO statistics(player, wins) VALUES (?, ?)")) {
            for (Map.Entry<Player, Integer> entry : dto.wins().entrySet()) {
                statement.setString(1, entry.getKey().name());
                statement.setInt(2, entry.getValue());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    private void rollback(Connection connection, SQLException original) {
        try {
            connection.rollback();
        } catch (SQLException suppressed) {
            original.addSuppressed(suppressed);
        }
    }

    private void closeQuietly(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new UncheckedSqlException(e);
        }
    }
}
