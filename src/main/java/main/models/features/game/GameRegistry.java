package main.models.features.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameRegistry {

    private static final GameRegistry instance = new GameRegistry();

    private final Map<Integer, GameSnapshot> snapshots;

    private int nextGameId;

    private GameRegistry() {
        this.snapshots = new LinkedHashMap<>();
        this.nextGameId = 1;
    }

    public static GameRegistry getInstance() {
        return instance;
    }

    public int nextId() {
        return nextGameId++;
    }

    public void save(GameSnapshot snapshot) {
        snapshots.put(snapshot.getGameId(), snapshot);
    }

    public List<GameSnapshot> getAll() {
        return new ArrayList<>(snapshots.values());
    }

    public GameSnapshot get(int index) {
        return getAll().get(index);
    }

    public int size() {
        return snapshots.size();
    }
}
