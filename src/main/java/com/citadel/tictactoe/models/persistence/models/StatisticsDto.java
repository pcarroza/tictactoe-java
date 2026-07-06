package com.citadel.tictactoe.models.persistence.models;

import com.citadel.tictactoe.models.features.game.Player;

import java.io.Serializable;
import java.util.Map;

public record StatisticsDto(Map<Player, Integer> wins) implements Serializable {
}
