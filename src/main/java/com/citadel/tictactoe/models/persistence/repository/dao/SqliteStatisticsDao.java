package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

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
        FileSupport.createDirectory(file);
        createSchema();
    }

    @Override
    public Optional<StatisticsDto> load() {
        return SqliteSupport.withConnection(file, connection -> {
            try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT player, wins FROM statistics")) {
                Map<Player, Integer> wins = new EnumMap<>(Player.class);
                while (resultSet.next()) {
                    wins.put(Player.valueOf(resultSet.getString("player")), resultSet.getInt("wins"));
                }
                return wins.isEmpty() ? Optional.empty() : Optional.of(new StatisticsDto(wins));
            }
        });
    }

    @Override
    public void save(StatisticsDto dto) {
        SqliteSupport.inTransaction(file, connection -> {
            clear(connection);
            insertAll(connection, dto);
        });
    }

    private void createSchema() {
        SqliteSupport.withConnection(file, connection -> {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS statistics (" + "player TEXT PRIMARY KEY, "
                        + "wins INTEGER NOT NULL)");
            }
            return null;
        });
    }

    private void clear(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM statistics");
        }
    }

    private void insertAll(Connection connection, StatisticsDto dto) throws SQLException {
        try (PreparedStatement statement = connection
                .prepareStatement("INSERT INTO statistics(player, wins) VALUES (?, ?)")) {
            for (Map.Entry<Player, Integer> entry : dto.wins().entrySet()) {
                statement.setString(1, entry.getKey().name());
                statement.setInt(2, entry.getValue());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }
}
