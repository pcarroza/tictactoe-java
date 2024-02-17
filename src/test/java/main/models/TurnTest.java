package main.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TurnTest {

    private Turn turn;

    @Before
    public void setUp() {
        this.turn = new Turn();
    }

    @Test
    public void givenTurn_whenGetCurrentPlayerInitialGame_thenEqualToZero() {
        final int INDEX_CURRENT_PLAYER = 0;
        assertThat(this.turn.getIndexCurrentPlayer(), is(equalTo(INDEX_CURRENT_PLAYER)));
    }

    @Test
    public void givenTurn_whenGetCurrentPlayerChangeTurn_thenEqualToOne() {
        final int INDEX_CURRENT_PLAYER = 1;
        this.turn.switchTurn();
        assertThat(this.turn.getIndexCurrentPlayer(), is(equalTo(INDEX_CURRENT_PLAYER)));
    }

    @Test
    public void givenTurn_whenTheTurnIsChangedTwice_thenEqualToZero() {
        final int INDEX_CURRENT_PLAYER = 0;
        this.turn.switchTurn();
        this.turn.switchTurn();
        assertThat(this.turn.getIndexCurrentPlayer(), is(equalTo(INDEX_CURRENT_PLAYER)));
    }

    @Test
    public void givenTurn_whenGetTakeColorInitialGameState_thenToEqualsOS() {
        assertThat(this.turn.getColorCurrentPlayer(), is(equalTo(Player.OS)));
    }

    @Test
    public void givenTurn_whenChangeTurnAndGetTakeColor_thenToEqualsXS() {
        this.turn.switchTurn();
        assertThat(this.turn.getColorCurrentPlayer(), is(equalTo(Player.XS)));
    }

    @Test
    public void givenTurn_givenTurn_whenTheTurnIsChangedTwice_thenToEqualsOS() {
        this.turn.switchTurn();
        this.turn.switchTurn();
        assertThat(this.turn.getColorCurrentPlayer(), is(equalTo(Player.OS)));
    }
}
