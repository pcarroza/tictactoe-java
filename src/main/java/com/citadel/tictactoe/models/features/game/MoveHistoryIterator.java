package com.citadel.tictactoe.models.features.game;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MoveHistoryIterator implements Iterator<MoveRecord> {

    private final List<MoveRecord> records;

    private int index;

    MoveHistoryIterator(List<MoveRecord> records) {
        this.records = records;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < records.size();
    }

    @Override
    public MoveRecord next() {
        if (!hasNext()) throw new NoSuchElementException();
        return records.get(index++);
    }
}
