package main.models.builders;

import main.models.Board;
import main.models.Color;
import main.models.Coordinate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BoardBuilder {

    private Board board;

    private List<String> rows;

    private static final Predicate<Character> COLORS = c -> c == 'X' || c == 'x' || c == 'O' || c == 'o';

    public BoardBuilder build() {
        board = new Board();
        rows = new ArrayList<>();
        return this;
    }

    public BoardBuilder put(Coordinate coordinate) {
        board.put(coordinate);
        return this;
    }

    public BoardBuilder put(String rows) {
        this.rows.add(rows);
        return this;
    }

    public BoardBuilder switchTurn() {
        board.switchTurn();
        return this;
    }

    public Board getBoard() {
        if (!rows.isEmpty()) {
            buildBoardFromRows();
        }
        return board;
    }

    private void buildBoardFromRows() {
        for (int i = 0; i < this.rows.size(); i++) {
            String rows = this.rows.get(i).replaceAll("\\s", "");
            for (int j = 0; j < rows.length(); j++) {
                char cell = rows.charAt(j);
                if (COLORS.test(cell)) {
                    Color player = cell == 'O' || cell == 'o' ? Color.OS : Color.XS;
                    switchTurnIfNeeded(player);
                    board.put(new Coordinate(i + 1, j + 1));
                }
            }
        }
    }

    private void buildSceneryBoardFromRows() {
        for (int i = 0; i < this.rows.size(); i++) {
            String rows = this.rows.get(i).replaceAll("\\s", "");
            for (int j = 0; j < rows.length(); j++) {
                Coordinate coordinate = new Coordinate(i + 1, j + 1);
                char cell = rows.charAt(j);
                if (cell == '-' && !board.isEmpty(coordinate)) {
                    board.remove(coordinate);
                } else if (COLORS.test(cell)) {
                    Color player = cell == 'O' || cell == 'o' ? Color.OS : Color.XS;
                    switchTurnIfNeeded(player);
                    board.put(new Coordinate(i + 1, j + 1));
                }
            }
        }
    }

    private BoardBuilder switchTurnToPlayerOS() {
        switchTurnIfNeeded(Color.OS);
        return this;
    }

    private BoardBuilder switchTurnToPlayerXS() {
        switchTurnIfNeeded(Color.XS);
        return this;
    }

    private void switchTurnIfNeeded(Color player) {
        if (board.getColorCurrentPlayer() != player) {
            board.switchTurn();
        }
    }

    private BoardBuilder loadScenery() {
        return closeScenery();
    }

    private BoardBuilder closeScenery() {
        buildBoardFromRows();
        rows.clear();
        return this;
    }

    public static void main(String[] args) {
        Board board = new BoardBuilder()
                .build()
                .put("O - -")
                .put("- - -")
                .put("- - -")
                .loadScenery()
                .put("O - -")
                .put("- X -")
                .put("- - -")
                .loadScenery()
                .put("O O -")
                .put("- X X")
                .put("- - -")
                .loadScenery()
                .put("O O -")
                .put("- X X")
                .put("- - O")
                .loadScenery()
                .put("O O -")
                .put("X X X")
                .put("- - O")
                .loadScenery()
                .put("O O -")
                .put("X X X")
                .put("- - O")
                .closeScenery()
                .switchTurnToPlayerXS()
                .getBoard();

        System.out.println(board.existTicTacToe());
        board.showFlat();
    }
}
