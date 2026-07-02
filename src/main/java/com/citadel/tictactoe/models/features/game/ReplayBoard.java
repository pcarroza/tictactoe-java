package com.citadel.tictactoe.models.features.game;

import java.util.List;

public class ReplayBoard {

    private final Board board;

    private final List<MoveRecord> records;

    private int position;

    public ReplayBoard(List<MoveRecord> records) {
        this.board = new Board();
        this.records = records;
        this.position = 0;
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
