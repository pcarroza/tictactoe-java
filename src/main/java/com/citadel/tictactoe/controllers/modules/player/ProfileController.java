package com.citadel.tictactoe.controllers.modules.player;

import com.citadel.tictactoe.models.modules.game.Player;

public interface ProfileController {

    String getName(Player token);

    void setName(Player token, String name);
}
