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
        turn = new Turn();
    }

    @Test
    public void givenTurn_whenGetCurrentPlayerInitialGame_thenEqualToZero() {
        final int INDEX_CURRENT_PLAYER = 0;
        assertThat(turn.getIndexCurrentPlayer(), is(equalTo(INDEX_CURRENT_PLAYER)));
    }

    @Test
    public void givenTurn_whenGetCurrentPlayerChangeTurn_thenEqualToOne() {
        final int INDEX_CURRENT_PLAYER = 1;
        turn.switchToNextPlayer();
        assertThat(turn.getIndexCurrentPlayer(), is(equalTo(INDEX_CURRENT_PLAYER)));
    }

    @Test
    public void givenTurn_whenTheTurnIsChangedTwice_thenEqualToZero() {
        final int INDEX_CURRENT_PLAYER = 0;
        turn.switchToNextPlayer();
        turn.switchToNextPlayer();
        assertThat(turn.getIndexCurrentPlayer(), is(equalTo(INDEX_CURRENT_PLAYER)));
    }

    @Test
    public void givenTurn_whenGetTakeColorInitialGameState_thenToEqualsOS() {
        assertThat(turn.getCurrentPlayer(), is(equalTo(Color.OS)));
    }

    @Test
    public void givenTurn_whenChangeTurnAndGetTakeColor_thenToEqualsXS() {
        turn.switchToNextPlayer();
        assertThat(turn.getCurrentPlayer(), is(equalTo(Color.XS)));
    }

    @Test
    public void givenTurn_givenTurn_whenTheTurnIsChangedTwice_thenToEqualsOS() {
        turn.switchToNextPlayer();
        turn.switchToNextPlayer();
        assertThat(turn.getCurrentPlayer(), is(equalTo(Color.OS)));
    }
}
