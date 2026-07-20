package com.citadel.tictactoe.persistence;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.models.StatisticsDto;
import com.citadel.tictactoe.models.persistence.repository.dao.SqliteStatisticsDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SqliteStatisticsDaoTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void givenNoDataYet_whenLoad_thenEmpty() {
        Path file = tempFolder.getRoot().toPath().resolve("statistics.db");
        SqliteStatisticsDao dao = new SqliteStatisticsDao(file);

        assertThat(dao.load(), is(equalTo(Optional.empty())));
    }

    @Test
    public void givenDtoSaved_whenReadWithNewDaoInstance_thenDataSurvives() {
        Path file = tempFolder.getRoot().toPath().resolve("statistics.db");
        SqliteStatisticsDao writer = new SqliteStatisticsDao(file);

        Map<Player, Integer> wins = new EnumMap<>(Player.class);
        wins.put(Player.XS, 3);
        wins.put(Player.OS, 1);
        writer.save(new StatisticsDto(wins));

        SqliteStatisticsDao reader = new SqliteStatisticsDao(file);
        Optional<StatisticsDto> loaded = reader.load();

        assertThat(loaded.isPresent(), is(true));
        assertThat(loaded.get().wins().get(Player.XS), is(equalTo(3)));
        assertThat(loaded.get().wins().get(Player.OS), is(equalTo(1)));
    }
}
