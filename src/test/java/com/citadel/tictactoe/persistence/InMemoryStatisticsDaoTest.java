package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.models.StatisticsDto;
import com.citadel.tictactoe.models.persistence.repository.dao.InMemoryStatisticsDao;
import org.junit.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InMemoryStatisticsDaoTest {

    @Test
    public void givenNothingSaved_whenLoad_thenEmpty() {
        InMemoryStatisticsDao dao = new InMemoryStatisticsDao();

        assertThat(dao.load().isPresent(), is(false));
    }

    @Test
    public void givenDtoSaved_whenLoad_thenReturnsIt() {
        InMemoryStatisticsDao dao = new InMemoryStatisticsDao();
        Map<Player, Integer> wins = new EnumMap<>(Player.class);
        wins.put(Player.XS, 3);
        dao.save(new StatisticsDto(wins));

        assertThat(dao.load().get().wins().get(Player.XS), is(equalTo(3)));
    }
}
