package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.MoveRecord;
import com.citadel.tictactoe.models.modules.game.MoveType;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.repository.dao.SqliteGameDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SqliteGameDaoTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void givenSnapshotSaved_whenReadWithNewDaoInstance_thenDataSurvives() {
        Path file = tempFolder.getRoot().toPath().resolve("games.db");
        SqliteGameDao writer = new SqliteGameDao(file);

        Set<Coordinate> xsCoordinates = new HashSet<>();
        xsCoordinates.add(new Coordinate(1, 1));
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        positions.put(Player.XS, xsCoordinates);
        positions.put(Player.OS, new HashSet<>());
        MoveHistory history = new MoveHistory();
        history.record(new MoveRecord(Player.XS, MoveType.PUT, new Coordinate(1, 1), 1));
        GameSnapshot original = new GameSnapshot(positions, 1, 2, 7, history);

        writer.save(original);

        SqliteGameDao reader = new SqliteGameDao(file);
        List<GameSnapshot> loaded = reader.findAll();

        assertThat(loaded.size(), is(equalTo(1)));
        GameSnapshot restored = loaded.get(0);
        assertThat(restored.gameId(), is(equalTo(7)));
        assertThat(restored.currentPlayerIndex(), is(equalTo(1)));
        assertThat(restored.getNumberUsers(), is(equalTo(2)));
        assertThat(restored.positions().get(Player.XS), is(equalTo(xsCoordinates)));
        assertThat(restored.history().size(), is(equalTo(1)));
    }

    @Test
    public void givenSnapshotAlreadySaved_whenNewDaoInstanceAsksNextId_thenContinuesFromMax() {
        Path file = tempFolder.getRoot().toPath().resolve("games.db");
        SqliteGameDao writer = new SqliteGameDao(file);
        writer.save(minimalSnapshot(5));

        SqliteGameDao reader = new SqliteGameDao(file);
        assertThat(reader.nextId(), is(equalTo(6)));
    }

    @Test
    public void givenSnapshotWithSameGameIdSavedTwice_whenFindAll_thenReplacesNotDuplicates() {
        Path file = tempFolder.getRoot().toPath().resolve("games.db");
        SqliteGameDao writer = new SqliteGameDao(file);

        writer.save(minimalSnapshot(3));
        writer.save(new GameSnapshot(minimalPositions(), 1, 2, 3, new MoveHistory()));

        SqliteGameDao reader = new SqliteGameDao(file);
        List<GameSnapshot> loaded = reader.findAll();

        assertThat(loaded.size(), is(equalTo(1)));
        assertThat(loaded.get(0).currentPlayerIndex(), is(equalTo(1)));
    }

    @Test
    public void givenPlayerWithNoCoordinates_whenReadWithNewDaoInstance_thenEmptySetPreservedNotMissingKey() {
        Path file = tempFolder.getRoot().toPath().resolve("games.db");
        SqliteGameDao writer = new SqliteGameDao(file);
        writer.save(minimalSnapshot(9));

        SqliteGameDao reader = new SqliteGameDao(file);
        GameSnapshot restored = reader.findAll().get(0);

        assertThat(restored.positions().containsKey(Player.OS), is(true));
        assertThat(restored.positions().get(Player.OS), is(equalTo(new HashSet<>())));
    }

    @Test
    public void givenMultipleMoves_whenReadWithNewDaoInstance_thenHistoryOrderPreserved() {
        Path file = tempFolder.getRoot().toPath().resolve("games.db");
        SqliteGameDao writer = new SqliteGameDao(file);

        MoveHistory history = new MoveHistory();
        List<MoveRecord> expected = new ArrayList<>();
        expected.add(new MoveRecord(Player.XS, MoveType.PUT, new Coordinate(1, 1), 1));
        expected.add(new MoveRecord(Player.OS, MoveType.PUT, new Coordinate(2, 2), 2));
        expected.add(new MoveRecord(Player.XS, MoveType.PUT, new Coordinate(3, 3), 3));
        expected.forEach(history::record);
        writer.save(new GameSnapshot(minimalPositions(), 0, 2, 11, history));

        SqliteGameDao reader = new SqliteGameDao(file);
        GameSnapshot restored = reader.findAll().get(0);

        assertThat(toList(restored.history()), is(equalTo(expected)));
    }

    private List<MoveRecord> toList(MoveHistory history) {
        List<MoveRecord> records = new ArrayList<>();
        history.forEach(records::add);
        return records;
    }

    private GameSnapshot minimalSnapshot(int gameId) {
        return new GameSnapshot(minimalPositions(), 0, 2, gameId, new MoveHistory());
    }

    private Map<Player, Set<Coordinate>> minimalPositions() {
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        positions.put(Player.XS, new HashSet<>());
        positions.put(Player.OS, new HashSet<>());
        return positions;
    }
}
