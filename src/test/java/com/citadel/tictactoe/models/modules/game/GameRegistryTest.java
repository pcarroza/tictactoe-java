package com.citadel.tictactoe.models.modules.game;

import com.citadel.tictactoe.models.persistence.repository.dao.InMemoryGameDao;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameRegistryTest {

    private GameRegistry registry;

    @Before
    public void setUp() {
        registry = new GameRegistry(new InMemoryGameDao());
    }

    @Test
    public void givenNoGamesSaved_whenSize_thenZero() {
        assertThat(registry.size(), is(equalTo(0)));
    }

    @Test
    public void givenNoGamesSaved_whenNextId_thenStartsAtOne() {
        assertThat(registry.nextId(), is(equalTo(1)));
    }

    @Test
    public void givenSnapshotSaved_whenSize_thenOne() {
        registry.save(snapshot(1));

        assertThat(registry.size(), is(equalTo(1)));
    }

    @Test
    public void givenSnapshotSaved_whenGet_thenReturnsTheSameSnapshot() {
        GameSnapshot saved = snapshot(1);
        registry.save(saved);

        assertThat(registry.get(0), is(equalTo(saved)));
    }

    @Test
    public void givenTwoSnapshotsSaved_whenGetAll_thenContainsBoth() {
        registry.save(snapshot(1));
        registry.save(snapshot(2));

        assertThat(registry.getAll().size(), is(equalTo(2)));
    }

    private GameSnapshot snapshot(int gameId) {
        return new GameSnapshot(Map.<Player, Set<Coordinate>>of(), 0, 1, gameId, new MoveHistory());
    }
}
