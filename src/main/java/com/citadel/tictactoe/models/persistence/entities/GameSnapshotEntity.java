package com.citadel.tictactoe.models.persistence.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public record GameSnapshotEntity(
        int gameId,
        Map<String, List<int[]>> positions,
        int currentPlayerIndex,
        int numberUsers,
        List<MoveRecordEntity> history) implements Serializable {
}
