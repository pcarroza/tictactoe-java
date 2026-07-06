package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.persistence.repository.dao.InMemoryStatisticsDao;
import com.citadel.tictactoe.models.persistence.service.StatisticsService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StatisticsServiceTest {

    private StatisticsService service;

    @Before
    public void setUp() {
        service = new StatisticsService(new InMemoryStatisticsDao());
    }

    @Test
    public void givenNoWinsRecorded_whenGetWins_thenZero() {
        assertThat(service.getWins(Player.XS), is(equalTo(0)));
    }

    @Test
    public void givenPlayerWinsTwice_whenGetWins_thenAccumulates() {
        service.recordWin(Player.XS);
        service.recordWin(Player.XS);

        assertThat(service.getWins(Player.XS), is(equalTo(2)));
    }

    @Test
    public void givenBothPlayersWin_whenGetTotalGames_thenSumsAll() {
        service.recordWin(Player.XS);
        service.recordWin(Player.OS);
        service.recordWin(Player.XS);

        assertThat(service.getTotalGames(), is(equalTo(3)));
    }
}
