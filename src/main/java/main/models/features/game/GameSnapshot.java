package main.models.features.game;

import java.util.*;

public class GameSnapshot {

    private final int gameId;

    private final Map<Player, Set<Coordinate>> positions;

    private final int currentPlayerIndex;

    private final int numUsers;

    public GameSnapshot(Map<Player, Set<Coordinate>> positions, int currentPlayerIndex, int numUsers, int gameId) {
        this.gameId = gameId;
        this.positions = positions;
        this.currentPlayerIndex = currentPlayerIndex;
        this.numUsers = numUsers;
    }

    public int getGameId() {
        return gameId;
    }

    public Map<Player, Set<Coordinate>> getPositions() {
        return positions;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public int getNumUsers() {
        return numUsers;
    }

}
