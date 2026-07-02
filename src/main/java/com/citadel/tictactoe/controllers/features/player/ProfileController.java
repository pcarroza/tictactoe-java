package com.citadel.tictactoe.controllers.features.player;

import com.citadel.tictactoe.models.features.game.Player;

public interface ProfileController {

    String getName(Player token);

    void setName(Player token, String name);
}
