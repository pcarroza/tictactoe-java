package com.citadel.tictactoe.models.modules.game;

import java.util.Map;
import java.util.Set;

public record GameSnapshot(Map<Player,Set<Coordinate>>positions,int currentPlayerIndex,int getNumberUsers,int gameId,MoveHistory history){}
