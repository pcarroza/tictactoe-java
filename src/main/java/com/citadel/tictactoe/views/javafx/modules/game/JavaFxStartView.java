package com.citadel.tictactoe.views.javafx.modules.game;

import com.citadel.tictactoe.controllers.modules.game.StartController;
import com.citadel.tictactoe.controllers.modules.game.local.ai.AiDifficulty;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class JavaFxStartView {

    void interact(StartController startController, Stage stage, Runnable onDone) {
        ChoiceBox<Integer> players = new ChoiceBox<>(FXCollections.observableArrayList(0, 1, 2));
        players.setValue(1);
        CheckBox hardAi = new CheckBox("IA en modo difícil (solo si hay menos de 2 jugadores)");
        Button confirm = new Button("Comenzar");
        confirm.setOnAction(event -> confirm(startController, players.getValue(), hardAi.isSelected(), onDone));
        VBox box = new VBox(12, new Label("¿Cuántos jugadores? (0 = IA vs IA)"), players, hardAi, confirm);
        box.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(box, 600, 600));
        stage.setTitle("TicTacToe (JavaFX)");
        stage.show();
    }

    private void confirm(StartController startController, int users, boolean hardAi, Runnable onDone) {
        AiDifficulty difficulty = users < 2 && hardAi ? AiDifficulty.HARD : AiDifficulty.EASY;
        startController.start(users, difficulty);
        onDone.run();
    }
}
