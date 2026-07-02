package com.citadel.tictactoe.models.features.player;

import com.citadel.tictactoe.models.features.game.Player;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class ProfileRegistry {

    private static final ProfileRegistry instance = new ProfileRegistry();

    private final Map<Player, PlayerProfile> profiles;

    private ProfileRegistry() {
        this.profiles = new EnumMap<>(Player.class);
    }

    public static ProfileRegistry getInstance() {
        return instance;
    }

    public void register(PlayerProfile profile) {
        profiles.put(profile.token(), profile);
    }

    public Optional<PlayerProfile> findByToken(Player token) {
        return Optional.ofNullable(profiles.get(token));
    }
}
