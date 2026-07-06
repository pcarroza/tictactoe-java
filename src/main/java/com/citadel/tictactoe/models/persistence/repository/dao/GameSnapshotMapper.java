package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.MoveRecord;
import com.citadel.tictactoe.models.features.game.MoveType;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.persistence.entities.GameSnapshotEntity;
import com.citadel.tictactoe.models.persistence.entities.MoveRecordEntity;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GameSnapshotMapper {

    static GameSnapshotEntity toEntity(GameSnapshot snapshot) {
        Map<String, List<int[]>> positions = new LinkedHashMap<>();
        snapshot.positions().forEach((player, coordinates) -> {
            List<int[]> cells = new ArrayList<>();
            coordinates.forEach(coordinate -> cells.add(new int[]{coordinate.getRow(), coordinate.getColumn()}));
            positions.put(player.name(), cells);
        });
        List<MoveRecordEntity> history = new ArrayList<>();
        snapshot.history().forEach(record -> history.add(new MoveRecordEntity(
                record.player().name(), record.type().name(),
                record.coordinate().getRow(), record.coordinate().getColumn(), record.turn())));
        return new GameSnapshotEntity(snapshot.gameId(), positions, snapshot.currentPlayerIndex(),
                snapshot.getNumberUsers(), history);
    }

    static GameSnapshot toDomain(GameSnapshotEntity entity) {
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        entity.positions().forEach((playerName, cells) -> {
            Set<Coordinate> coordinates = new HashSet<>();
            cells.forEach(cell -> coordinates.add(new Coordinate(cell[0], cell[1])));
            positions.put(Player.valueOf(playerName), coordinates);
        });
        MoveHistory history = new MoveHistory();
        entity.history().forEach(record -> history.record(new MoveRecord(
                Player.valueOf(record.player()), MoveType.valueOf(record.type()),
                new Coordinate(record.row(), record.column()), record.turn())));
        return new GameSnapshot(positions, entity.currentPlayerIndex(), entity.numberUsers(),
                entity.gameId(), history);
    }
}
