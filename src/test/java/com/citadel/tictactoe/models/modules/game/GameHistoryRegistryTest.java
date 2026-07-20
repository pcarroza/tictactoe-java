package com.citadel.tictactoe.models.modules.game;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameHistoryRegistryTest {

    private GameHistoryRegistry registry;

    @Before
    public void setUp() {
        registry = new GameHistoryRegistry();
    }

    @Test
    public void givenNoHistoryRecorded_whenSize_thenZero() {
        assertThat(registry.size(), is(equalTo(0)));
    }

    @Test
    public void givenHistoryRecorded_whenSize_thenOne() {
        registry.record(new MoveHistory());

        assertThat(registry.size(), is(equalTo(1)));
    }

    @Test
    public void givenHistoryRecorded_whenGet_thenReturnsTheSameHistory() {
        MoveHistory history = new MoveHistory();
        registry.record(history);

        assertThat(registry.get(0), is(equalTo(history)));
    }

    @Test
    public void givenTwoHistoriesRecorded_whenGetAll_thenContainsBoth() {
        registry.record(new MoveHistory());
        registry.record(new MoveHistory());

        assertThat(registry.getAll().size(), is(equalTo(2)));
    }
}
