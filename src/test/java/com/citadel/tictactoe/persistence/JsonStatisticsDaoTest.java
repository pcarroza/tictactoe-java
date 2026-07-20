package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.models.StatisticsDto;
import com.citadel.tictactoe.models.persistence.repository.dao.JsonStatisticsDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonStatisticsDaoTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void givenNoFileYet_whenLoad_thenEmpty() {
        Path file = tempFolder.getRoot().toPath().resolve("statistics.json");
        JsonStatisticsDao dao = new JsonStatisticsDao(file);

        assertThat(dao.load().isPresent(), is(false));
    }

    @Test
    public void givenDtoSaved_whenReadWithNewDaoInstance_thenDataSurvives() {
        Path file = tempFolder.getRoot().toPath().resolve("statistics.json");
        Map<Player, Integer> wins = new EnumMap<>(Player.class);
        wins.put(Player.XS, 4);
        wins.put(Player.OS, 2);
        new JsonStatisticsDao(file).save(new StatisticsDto(wins));

        StatisticsDto loaded = new JsonStatisticsDao(file).load().get();

        assertThat(loaded.wins().get(Player.XS), is(equalTo(4)));
        assertThat(loaded.wins().get(Player.OS), is(equalTo(2)));
    }
}
