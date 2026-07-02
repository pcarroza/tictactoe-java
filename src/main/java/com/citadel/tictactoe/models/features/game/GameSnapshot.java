package com.citadel.tictactoe.models.features.game;

import java.util.Map;
import java.util.Set;

public record GameSnapshot(Map<Player, Set<Coordinate>> positions, int currentPlayerIndex, int numUsers, int gameId, MoveHistory history) {
}
