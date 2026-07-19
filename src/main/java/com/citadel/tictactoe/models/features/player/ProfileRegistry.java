package com.citadel.tictactoe.models.features.player;

import com.citadel.tictactoe.models.features.game.Player;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class ProfileRegistry {

    private final Map<Player, PlayerProfile> profiles;

    public ProfileRegistry() {
        this.profiles = new EnumMap<>(Player.class);
    }

    public void register(PlayerProfile profile) {
        profiles.put(profile.token(), profile);
    }

    public Optional<PlayerProfile> findBy(Player token) {
        return Optional.ofNullable(profiles.get(token));
    }
}
