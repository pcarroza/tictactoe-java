package com.citadel.tictactoe.controllers.features.player.local;

import com.citadel.tictactoe.controllers.features.player.ProfileController;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.player.PlayerProfile;
import com.citadel.tictactoe.models.features.player.ProfileRegistry;

public class LocalProfileController implements ProfileController {

    @Override
    public String getName(Player token) {
        return ProfileRegistry.getInstance().findByToken(token)
                .map(PlayerProfile::name)
                .orElse(token == Player.XS ? "X" : "O");
    }

    @Override
    public void setName(Player token, String name) {
        ProfileRegistry.getInstance().register(new PlayerProfile(token, name));
    }
}
