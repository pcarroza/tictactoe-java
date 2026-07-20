package com.citadel.tictactoe.views.javafx.modules.game;

import com.citadel.tictactoe.controllers.modules.game.PresenterController;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Player;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

class JavaFxBoardView {

    private final GridPane grid = new GridPane();

    private final Button[][] cells = new Button[Coordinate.DIMENSION][Coordinate.DIMENSION];

    private final Label status = new Label();

    private final BorderPane root = new BorderPane();

    JavaFxBoardView() {
        buildGrid();
        root.setCenter(grid);
        root.setBottom(status);
    }

    private void buildGrid() {
        for (int row = 1; row <= Coordinate.DIMENSION; row++) {
            for (int column = 1; column <= Coordinate.DIMENSION; column++) {
                Button cell = new Button();
                cell.setPrefSize(80, 80);
                grid.add(cell, column - 1, row - 1);
                cells[row - 1][column - 1] = cell;
            }
        }
    }

    Parent getRoot() {
        return root;
    }

    void render(PresenterController presenter) {
        for (int row = 1; row <= Coordinate.DIMENSION; row++) {
            for (int column = 1; column <= Coordinate.DIMENSION; column++) {
                cells[row - 1][column - 1].setText(symbol(presenter.getColor(new Coordinate(row, column))));
            }
        }
    }

    private String symbol(Player player) {
        if (player == Player.OS) {
            return "O";
        }
        if (player == Player.XS) {
            return "X";
        }
        return "";
    }

    void onCellClick(Consumer<Coordinate> handler) {
        for (int row = 1; row <= Coordinate.DIMENSION; row++) {
            for (int column = 1; column <= Coordinate.DIMENSION; column++) {
                int clickedRow = row;
                int clickedColumn = column;
                cells[row - 1][column - 1].setOnAction(event -> handler.accept(new Coordinate(clickedRow, clickedColumn)));
            }
        }
    }

    void setInteractive(boolean interactive) {
        for (Button[] rowCells : cells) {
            for (Button cell : rowCells) {
                cell.setDisable(!interactive);
            }
        }
    }

    void showStatus(String text) {
        status.setText(text);
    }
}
