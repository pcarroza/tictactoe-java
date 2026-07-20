package com.citadel.tictactoe.models.modules.game.events;

import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Player;

public record GameEndedEvent(Player winner, MoveHistory history) {
}
