package com.citadel.tictactoe.models.features.game;

import java.util.*;

public record GameSnapshot(Map<Player, Set<Coordinate>> positions, int currentPlayerIndex, int numUsers, int gameId) {
}
