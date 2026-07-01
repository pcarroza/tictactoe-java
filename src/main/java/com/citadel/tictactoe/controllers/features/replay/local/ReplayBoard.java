package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.models.features.game.Board;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveRecord;
import com.citadel.tictactoe.models.features.game.MoveType;
import com.citadel.tictactoe.models.features.game.Player;

class ReplayBoard {

    private final Board board;

    ReplayBoard() {
        this.board = new Board();
    }

    void apply(MoveRecord record) {
        board.flat.get(record.player()).add(record.coordinate());
        if (record.type() == MoveType.PUT) {
            board.changeTurn();
        }
    }

    void reverse(MoveRecord record) {
        if (record.type() == MoveType.PUT) {
            board.changeTurn();
            board.flat.get(record.player()).remove(record.coordinate());
        } else {
            board.flat.get(record.player()).add(record.coordinate());
        }
    }

    Player getColor(Coordinate coordinate) {
        return board.getPlayer(coordinate);
    }
}
