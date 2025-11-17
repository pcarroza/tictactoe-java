package main.models.builders;

import main.models.modules.game.Board;
import main.models.modules.game.Player;
import main.models.modules.game.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BoardBuilder {

    private Board board;

    private List<String> rows;

    private static final Predicate<Character> OS = c -> c == 'O' || c == 'o';

    private static final Predicate<Character> XS = c -> c == 'X' || c == 'x';

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
        board.changeTurn();
        return this;
    }

    public Board getBoard() {
        if (!rows.isEmpty()) {
            buildBoardFromRows();
        }
        return board;
    }

    private void buildBoardFromRows() {
        for (int i = 1; i <= rows.size(); i++) {
            String rows = this.rows.get(i - 1).replaceAll("\\s", "");
            for (int j = 1; j <= rows.length(); j++) {
                Coordinate coordinate = new Coordinate(i, j);
                char cell = rows.charAt(j - 1);
                if (cell == '-' && !board.isEmpty(coordinate)) {
                    handleEmptyCell(coordinate);
                } else {
                    handleNonEmptyCell(cell, coordinate);
                }
            }
        }
    }

    private void handleEmptyCell(Coordinate coordinate) {
        if (board.getPlayerCoordinates().contains(coordinate)) {
            board.remove(coordinate);
        } else {
            board.changeTurn();
            board.remove(coordinate);
        }
    }

    private void handleNonEmptyCell(char cell, Coordinate coordinate) {
        Player player = null;
        if (OS.test(cell) && board.isEmpty(coordinate)) {
            player = Player.OS;
        } else if (XS.test(cell) && board.isEmpty(coordinate)) {
            player = Player.XS;
        }
        if (player != null) {
            switchTurnIfNeeded(player);
            board.put(coordinate);
        }
    }

    public BoardBuilder switchTurnToPlayerOS() {
        switchTurnIfNeeded(Player.OS);
        return this;
    }

    public BoardBuilder switchTurnToPlayerXS() {
        switchTurnIfNeeded(Player.XS);
        return this;
    }

    private void switchTurnIfNeeded(Player player) {
        if (board.getColorCurrentPlayer() != player) {
            board.changeTurn();
        }
    }

    public BoardBuilder loadScenery() {
        return closeScenery();
    }

    public BoardBuilder closeScenery() {
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
                .put("- X -")
                .put("- - -")
                .loadScenery()
                .put("O O -")
                .put("- X -")
                .put("- - X")
                .loadScenery()
                .put("O O -")
                .put("- X -")
                .put("- O X")
                .loadScenery()
                .put("O O X")
                .put("- X -")
                .put("- O X")
                .loadScenery()
                .put("O O X")
                .put("- X -")
                .put("O - X")
                .loadScenery()
                .put("O O X")
                .put("- - X")
                .put("O - X")
                .closeScenery()
                .switchTurnToPlayerXS()
                .getBoard();

        System.out.println(board.existTicTacToe());
        board.showFlat();

    }
}
