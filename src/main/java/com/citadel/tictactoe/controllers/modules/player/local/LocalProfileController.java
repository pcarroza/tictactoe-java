package com.citadel.tictactoe.controllers.modules.player.local;

import com.citadel.tictactoe.controllers.modules.player.ProfileController;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.modules.player.PlayerProfile;
import com.citadel.tictactoe.models.modules.player.ProfileRegistry;

public class LocalProfileController implements ProfileController {

    private final ProfileRegistry profileRegistry;

    public LocalProfileController(ProfileRegistry profileRegistry) {
        this.profileRegistry = profileRegistry;
    }

    @Override
    public String getName(Player token) {
        return profileRegistry.findBy(token)
                .map(PlayerProfile::name)
                .orElse(token == Player.XS ? "X" : "O");
    }

    @Override
    public void setName(Player token, String name) {
        profileRegistry.register(new PlayerProfile(token, name));
    }
}
