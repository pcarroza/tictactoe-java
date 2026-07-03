package com.citadel.tictactoe.models.features.game.events;

import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.Player;

public record GameEndedEvent(Player winner, MoveHistory history) {
}
