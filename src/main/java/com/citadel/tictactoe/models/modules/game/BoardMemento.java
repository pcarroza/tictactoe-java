package com.citadel.tictactoe.models.modules.game;

import java.util.Map;
import java.util.Set;

record BoardMemento(Map<Player, Set<Coordinate>> positions, int turnIndex) {
}
