package com.citadel.tictactoe.models.features.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoveHistory implements Iterable<MoveRecord> {

    private final List<MoveRecord> records;

    public MoveHistory() {
        this.records = new ArrayList<>();
    }

    public void record(MoveRecord entry) {
        records.add(entry);
    }

    public void clear() {
        records.clear();
    }

    public int size() {
        return records.size();
    }

    @Override
    public Iterator<MoveRecord> iterator() {
        return new MoveHistoryIterator(new ArrayList<>(records));
    }
}
