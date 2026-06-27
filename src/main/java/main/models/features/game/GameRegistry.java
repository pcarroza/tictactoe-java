package main.models.features.game;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private static final GameRegistry instance = new GameRegistry();

    private final List<GameSnapshot> snapshots;

    private GameRegistry() {
        this.snapshots = new ArrayList<>();
    }

    public static GameRegistry getInstance() {
        return instance;
    }

    public void save(GameSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    public List<GameSnapshot> getAll() {
        return snapshots;
    }

    public GameSnapshot get(int index) {
        return snapshots.get(index);
    }

    public int size() {
        return snapshots.size();
    }
}
