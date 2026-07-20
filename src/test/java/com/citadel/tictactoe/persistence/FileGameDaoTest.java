package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.MoveRecord;
import com.citadel.tictactoe.models.modules.game.MoveType;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.repository.dao.FileGameDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.nio.file.Path;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileGameDaoTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void givenSnapshotSaved_whenReadWithNewDaoInstance_thenDataSurvives() {
        Path file = tempFolder.getRoot().toPath().resolve("games.ser");
        FileGameDao writer = new FileGameDao(file);

        Set<Coordinate> xsCoordinates = new HashSet<>();
        xsCoordinates.add(new Coordinate(1, 1));
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        positions.put(Player.XS, xsCoordinates);
        positions.put(Player.OS, new HashSet<>());
        MoveHistory history = new MoveHistory();
        history.record(new MoveRecord(Player.XS, MoveType.PUT, new Coordinate(1, 1), 1));
        GameSnapshot original = new GameSnapshot(positions, 1, 2, 7, history);

        writer.save(original);

        FileGameDao reader = new FileGameDao(file);
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
        Path file = tempFolder.getRoot().toPath().resolve("games.ser");
        FileGameDao writer = new FileGameDao(file);
        writer.save(minimalSnapshot(5));
        FileGameDao reader = new FileGameDao(file);
        assertThat(reader.nextId(), is(equalTo(6)));
    }

    private GameSnapshot minimalSnapshot(int gameId) {
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        positions.put(Player.XS, new HashSet<>());
        positions.put(Player.OS, new HashSet<>());
        return new GameSnapshot(positions, 0, 2, gameId, new MoveHistory());
    }
}
