package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.MoveRecord;
import com.citadel.tictactoe.models.modules.game.MoveType;
import com.citadel.tictactoe.models.modules.game.Player;
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
        return new GameSnapshotEntity(
                snapshot.gameId(),
                positionsToEntity(snapshot.positions()),
                snapshot.currentPlayerIndex(),
                snapshot.getNumberUsers(),
                historyToEntity(snapshot.history()));
    }

    static GameSnapshot toDomain(GameSnapshotEntity entity) {
        return new GameSnapshot(
                positionsToDomain(entity.positions()),
                entity.currentPlayerIndex(),
                entity.numberUsers(),
                entity.gameId(),
                historyToDomain(entity.history()));
    }

    private static Map<String, List<int[]>> positionsToEntity(Map<Player, Set<Coordinate>> positions) {
        Map<String, List<int[]>> entity = new LinkedHashMap<>();
        positions.forEach((player, coordinates) -> entity.put(player.name(), coordinatesToCells(coordinates)));
        return entity;
    }

    private static List<int[]> coordinatesToCells(Set<Coordinate> coordinates) {
        List<int[]> cells = new ArrayList<>();
        coordinates.forEach(coordinate -> cells.add(new int[]{coordinate.getRow(), coordinate.getColumn()}));
        return cells;
    }

    private static List<MoveRecordEntity> historyToEntity(MoveHistory history) {
        List<MoveRecordEntity> entity = new ArrayList<>();
        history.forEach(record -> entity.add(new MoveRecordEntity(
                record.player().name(),
                record.type().name(),
                record.coordinate().getRow(),
                record.coordinate().getColumn(),
                record.turn())));
        return entity;
    }

    private static Map<Player, Set<Coordinate>> positionsToDomain(Map<String, List<int[]>> positions) {
        Map<Player, Set<Coordinate>> domain = new EnumMap<>(Player.class);
        positions.forEach((playerName, cells) -> domain.put(Player.valueOf(playerName), cellsToCoordinates(cells)));
        return domain;
    }

    private static Set<Coordinate> cellsToCoordinates(List<int[]> cells) {
        Set<Coordinate> coordinates = new HashSet<>();
        cells.forEach(cell -> coordinates.add(new Coordinate(cell[0], cell[1])));
        return coordinates;
    }

    private static MoveHistory historyToDomain(List<MoveRecordEntity> history) {
        MoveHistory domain = new MoveHistory();
        history.forEach(record -> domain.record(
                new MoveRecord(Player.valueOf(record.player()), MoveType.valueOf(record.type()),
                new Coordinate(record.row(), record.column()), record.turn())));
        return domain;
    }
}
