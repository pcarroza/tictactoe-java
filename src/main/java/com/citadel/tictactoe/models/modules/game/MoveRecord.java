package com.citadel.tictactoe.models.modules.game;

public record MoveRecord(Player player, MoveType type, Coordinate coordinate, int turn) {
}
