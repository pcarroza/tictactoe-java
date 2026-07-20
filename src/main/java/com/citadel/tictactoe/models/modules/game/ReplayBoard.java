package com.citadel.tictactoe.models.modules.game;

import java.util.ArrayList;
import java.util.List;

public class ReplayBoard extends ReplaySubject {

    private final Board board;

    private final List<MoveRecord> records;

    private int position;

    public ReplayBoard(MoveHistory history, ReplayObserver observer) {
        this.board = new Board();
        this.records = collectRecords(history);
        this.position = 0;
        subscribe(observer);
    }

    private static List<MoveRecord> collectRecords(Iterable<MoveRecord> history) {
        List<MoveRecord> list = new ArrayList<>();
        for (MoveRecord record : history) {
            list.add(record);
        }
        return list;
    }

    public void next() {
        MoveRecord record = records.get(position++);
        board.flat.get(record.player()).add(record.coordinate());
        if (record.type() == MoveType.PUT) {
            board.changeTurn();
        }
    }

    public void previous() {
        MoveRecord record = records.get(--position);
        if (record.type() == MoveType.PUT) {
            board.changeTurn();
            board.flat.get(record.player()).remove(record.coordinate());
        } else {
            board.flat.get(record.player()).add(record.coordinate());
        }
    }

    public Player getColor(Coordinate coordinate) {
        return board.getPlayer(coordinate);
    }

    public int getPosition() {
        return position;
    }

    public int getTotal() {
        return records.size();
    }

    public boolean hasNext() {
        return position < records.size();
    }

    public boolean hasPrevious() {
        return position > 0;
    }
}
