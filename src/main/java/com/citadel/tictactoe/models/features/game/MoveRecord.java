package com.citadel.tictactoe.models.features.game;

public record MoveRecord(Player player, MoveType type, Coordinate coordinate, int turn) {
}
