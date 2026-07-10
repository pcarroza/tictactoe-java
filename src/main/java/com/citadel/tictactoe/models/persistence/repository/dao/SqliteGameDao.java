package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.models.persistence.entities.GameSnapshotEntity;
import com.citadel.tictactoe.models.persistence.entities.MoveRecordEntity;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SqliteGameDao implements GameDao {

    private final Path file;

    public SqliteGameDao(Path file) {
        this.file = file;
        FileSupport.createDirectory(file);
        createSchema();
    }

    @Override
    public int nextId() {
        return SqliteSupport.withConnection(file, connection -> {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT COALESCE(MAX(game_id), 0) + 1 AS next_id FROM games")) {
                resultSet.next();
                return resultSet.getInt("next_id");
            }
        });
    }

    @Override
    public void save(GameSnapshot snapshot) {
        GameSnapshotEntity entity = GameSnapshotMapper.toEntity(snapshot);
        SqliteSupport.inTransaction(file, connection -> {
            deleteChildren(connection, entity.gameId());
            upsertGame(connection, entity);
            insertPlayers(connection, entity);
            insertPositions(connection, entity);
            insertMoves(connection, entity);
        });
    }

    @Override
    public List<GameSnapshot> findAll() {
        return SqliteSupport.withConnection(file, connection -> {
            List<GameRow> gameRows = queryGames(connection);
            Map<Integer, Set<String>> playersByGame = queryPlayers(connection);
            Map<Integer, Map<String, List<int[]>>> positionsByGame = queryPositions(connection, playersByGame);
            Map<Integer, List<MoveRecordEntity>> movesByGame = queryMoves(connection);
            return assembleSnapshots(gameRows, positionsByGame, movesByGame);
        });
    }

    private List<GameSnapshot> assembleSnapshots(List<GameRow> gameRows,
            Map<Integer, Map<String, List<int[]>>> positionsByGame,
            Map<Integer, List<MoveRecordEntity>> movesByGame) {
        List<GameSnapshot> result = new ArrayList<>();
        for (GameRow row : gameRows) {
            GameSnapshotEntity entity = new GameSnapshotEntity(
                    row.gameId(),
                    positionsByGame.getOrDefault(row.gameId(), new LinkedHashMap<>()),
                    row.currentPlayerIndex(),
                    row.numberUsers(),
                    movesByGame.getOrDefault(row.gameId(), new ArrayList<>()));
            result.add(GameSnapshotMapper.toDomain(entity));
        }
        return result;
    }

    private void createSchema() {
        SqliteSupport.withConnection(file, connection -> {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS games (" +
                        "game_id INTEGER PRIMARY KEY, " +
                        "current_player_index INTEGER NOT NULL, " +
                        "number_users INTEGER NOT NULL)");
                statement.execute("CREATE TABLE IF NOT EXISTS game_players (" +
                        "game_id INTEGER NOT NULL REFERENCES games(game_id) ON DELETE CASCADE, " +
                        "player TEXT NOT NULL, " +
                        "PRIMARY KEY (game_id, player))");
                statement.execute("CREATE TABLE IF NOT EXISTS positions (" +
                        "game_id INTEGER NOT NULL REFERENCES games(game_id) ON DELETE CASCADE, " +
                        "player TEXT NOT NULL, " +
                        "row_index INTEGER NOT NULL, " +
                        "col_index INTEGER NOT NULL)");
                statement.execute("CREATE INDEX IF NOT EXISTS idx_positions_game_id ON positions(game_id)");
                statement.execute("CREATE TABLE IF NOT EXISTS moves (" +
                        "game_id INTEGER NOT NULL REFERENCES games(game_id) ON DELETE CASCADE, " +
                        "seq INTEGER NOT NULL, " +
                        "player TEXT NOT NULL, " +
                        "type TEXT NOT NULL, " +
                        "row_index INTEGER NOT NULL, " +
                        "col_index INTEGER NOT NULL, " +
                        "turn INTEGER NOT NULL)");
                statement.execute("CREATE INDEX IF NOT EXISTS idx_moves_game_id ON moves(game_id)");
            }
            return null;
        });
    }

    private void deleteChildren(Connection connection, int gameId) throws SQLException {
        try (PreparedStatement deletePlayers = connection.prepareStatement("DELETE FROM game_players WHERE game_id = ?");
             PreparedStatement deletePositions = connection.prepareStatement("DELETE FROM positions WHERE game_id = ?");
             PreparedStatement deleteMoves = connection.prepareStatement("DELETE FROM moves WHERE game_id = ?")) {
            deletePlayers.setInt(1, gameId);
            deletePlayers.executeUpdate();
            deletePositions.setInt(1, gameId);
            deletePositions.executeUpdate();
            deleteMoves.setInt(1, gameId);
            deleteMoves.executeUpdate();
        }
    }

    private void upsertGame(Connection connection, GameSnapshotEntity entity) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT OR REPLACE INTO games(game_id, current_player_index, number_users) VALUES (?, ?, ?)")) {
            statement.setInt(1, entity.gameId());
            statement.setInt(2, entity.currentPlayerIndex());
            statement.setInt(3, entity.numberUsers());
            statement.executeUpdate();
        }
    }

    private void insertPlayers(Connection connection, GameSnapshotEntity entity) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO game_players(game_id, player) VALUES (?, ?)")) {
            for (String player : entity.positions().keySet()) {
                statement.setInt(1, entity.gameId());
                statement.setString(2, player);
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    private void insertPositions(Connection connection, GameSnapshotEntity entity) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO positions(game_id, player, row_index, col_index) VALUES (?, ?, ?, ?)")) {
            for (Map.Entry<String, List<int[]>> entry : entity.positions().entrySet()) {
                addPositionBatch(statement, entity.gameId(), entry);
            }
            statement.executeBatch();
        }
    }

    private void addPositionBatch(PreparedStatement statement, int gameId, Map.Entry<String, List<int[]>> entry) throws SQLException {
        for (int[] cell : entry.getValue()) {
            statement.setInt(1, gameId);
            statement.setString(2, entry.getKey());
            statement.setInt(3, cell[0]);
            statement.setInt(4, cell[1]);
            statement.addBatch();
        }
    }

    private void insertMoves(Connection connection, GameSnapshotEntity entity) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO moves(game_id, seq, player, type, row_index, col_index, turn) " + "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            List<MoveRecordEntity> history = entity.history();
            for (int i = 0; i < history.size(); i++) {
                addMoveBatch(statement, entity.gameId(), i, history.get(i));
            }
            statement.executeBatch();
        }
    }

    private void addMoveBatch(PreparedStatement statement, int gameId, int seq, MoveRecordEntity record)
            throws SQLException {
        statement.setInt(1, gameId);
        statement.setInt(2, seq);
        statement.setString(3, record.player());
        statement.setString(4, record.type());
        statement.setInt(5, record.row());
        statement.setInt(6, record.column());
        statement.setInt(7, record.turn());
        statement.addBatch();
    }

    private List<GameRow> queryGames(Connection connection) throws SQLException {
        List<GameRow> rows = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT game_id, current_player_index, number_users FROM games ORDER BY game_id")) {
            while (resultSet.next()) {
                rows.add(new GameRow(resultSet.getInt("game_id"), resultSet.getInt("current_player_index"),
                        resultSet.getInt("number_users")));
            }
        }
        return rows;
    }

    private Map<Integer, Set<String>> queryPlayers(Connection connection) throws SQLException {
        Map<Integer, Set<String>> playersByGame = new LinkedHashMap<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT game_id, player FROM game_players")) {
            while (resultSet.next()) {
                playersByGame.computeIfAbsent(resultSet.getInt("game_id"), id -> new LinkedHashSet<>())
                        .add(resultSet.getString("player"));
            }
        }
        return playersByGame;
    }

    private Map<Integer, Map<String, List<int[]>>> queryPositions(Connection connection, Map<Integer, Set<String>> playersByGame) throws SQLException {
        Map<Integer, Map<String, List<int[]>>> positionsByGame = seedPositions(playersByGame);
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT game_id, player, row_index, col_index FROM positions")) {
            while (resultSet.next()) {
                addPositionRow(positionsByGame, resultSet);
            }
        }
        return positionsByGame;
    }

    private Map<Integer, Map<String, List<int[]>>> seedPositions(Map<Integer, Set<String>> playersByGame) {
        Map<Integer, Map<String, List<int[]>>> positionsByGame = new LinkedHashMap<>();
        playersByGame.forEach((gameId, players) -> {
            Map<String, List<int[]>> positions = new LinkedHashMap<>();
            players.forEach(player -> positions.put(player, new ArrayList<>()));
            positionsByGame.put(gameId, positions);
        });
        return positionsByGame;
    }

    private void addPositionRow(Map<Integer, Map<String, List<int[]>>> positionsByGame, ResultSet resultSet)
            throws SQLException {
        int gameId = resultSet.getInt("game_id");
        positionsByGame.computeIfAbsent(gameId, id -> new LinkedHashMap<>())
                .computeIfAbsent(resultSet.getString("player"), p -> new ArrayList<>())
                .add(new int[]{resultSet.getInt("row_index"), resultSet.getInt("col_index")});
    }

    private Map<Integer, List<MoveRecordEntity>> queryMoves(Connection connection) throws SQLException {
        Map<Integer, List<MoveRecordEntity>> movesByGame = new LinkedHashMap<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT game_id, player, type, row_index, col_index, turn FROM moves " + "ORDER BY game_id, seq")) {
            while (resultSet.next()) {
                addMoveRow(movesByGame, resultSet);
            }
        }
        return movesByGame;
    }

    private void addMoveRow(Map<Integer, List<MoveRecordEntity>> movesByGame, ResultSet resultSet)
            throws SQLException {
        int gameId = resultSet.getInt("game_id");
        movesByGame.computeIfAbsent(gameId, id -> new ArrayList<>())
                .add(new MoveRecordEntity(
                        resultSet.getString("player"),
                        resultSet.getString("type"),
                        resultSet.getInt("row_index"),
                        resultSet.getInt("col_index"), resultSet.getInt("turn")));
    }

    private record GameRow(int gameId, int currentPlayerIndex, int numberUsers) {
    }
}
