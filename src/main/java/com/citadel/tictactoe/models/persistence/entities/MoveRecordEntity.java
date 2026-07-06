package com.citadel.tictactoe.models.persistence.entities;

import java.io.Serializable;

public record MoveRecordEntity(String player, String type, int row, int column, int turn)
        implements Serializable {
}
