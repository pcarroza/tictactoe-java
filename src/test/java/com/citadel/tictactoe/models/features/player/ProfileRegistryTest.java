package com.citadel.tictactoe.models.features.player;

import com.citadel.tictactoe.models.features.game.Player;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfileRegistryTest {

    private ProfileRegistry registry;

    @Before
    public void setUp() {
        registry = new ProfileRegistry();
    }

    @Test
    public void givenNoProfileRegistered_whenFindBy_thenEmpty() {
        assertThat(registry.findBy(Player.XS).isPresent(), is(false));
    }

    @Test
    public void givenProfileRegistered_whenFindBy_thenReturnsIt() {
        registry.register(new PlayerProfile(Player.XS, "Pablo"));

        assertThat(registry.findBy(Player.XS).map(PlayerProfile::name), is(equalTo(java.util.Optional.of("Pablo"))));
    }

    @Test
    public void givenProfileRegisteredTwice_whenFindBy_thenLatestWins() {
        registry.register(new PlayerProfile(Player.XS, "Pablo"));
        registry.register(new PlayerProfile(Player.XS, "Carroza"));

        assertThat(registry.findBy(Player.XS).map(PlayerProfile::name), is(equalTo(java.util.Optional.of("Carroza"))));
    }
}
