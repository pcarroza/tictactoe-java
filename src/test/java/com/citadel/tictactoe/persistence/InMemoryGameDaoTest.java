package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.repository.dao.InMemoryGameDao;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InMemoryGameDaoTest {

    private InMemoryGameDao dao;

    @Before
    public void setUp() {
        dao = new InMemoryGameDao();
    }

    @Test
    public void givenNewDao_whenNextIdCalledTwice_thenIncrements() {
        int first = dao.nextId();
        int second = dao.nextId();

        assertThat(second, is(equalTo(first + 1)));
    }

    @Test
    public void givenSnapshotSaved_whenSavedAgainWithSameId_thenReplacesInsteadOfDuplicating() {
        dao.save(snapshot(1, 0));
        dao.save(snapshot(1, 1));

        assertThat(dao.findAll().size(), is(equalTo(1)));
        assertThat(dao.findAll().get(0).currentPlayerIndex(), is(equalTo(1)));
    }

    private GameSnapshot snapshot(int gameId, int currentPlayerIndex) {
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        positions.put(Player.XS, new HashSet<>());
        positions.put(Player.OS, new HashSet<>());
        return new GameSnapshot(positions, currentPlayerIndex, 2, gameId, new MoveHistory());
    }
}
