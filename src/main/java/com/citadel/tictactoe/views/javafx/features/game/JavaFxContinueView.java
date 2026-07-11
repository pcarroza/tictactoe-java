package com.citadel.tictactoe.views.javafx.features.game;

import com.citadel.tictactoe.controllers.features.game.ContinueController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class JavaFxContinueView {

    void interact(ContinueController continueController, Stage stage, Runnable onDone) {
        Button yes = new Button("Sí");
        Button no = new Button("No");
        yes.setOnAction(event -> resume(continueController, true, onDone));
        no.setOnAction(event -> resume(continueController, false, onDone));
        HBox buttons = new HBox(12, yes, no);
        buttons.setAlignment(Pos.CENTER);
        VBox box = new VBox(12, new Label("¿Desea continuar?"), buttons);
        box.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(box, 600, 600));
        stage.setTitle("TicTacToe (JavaFX)");
        stage.show();
    }

    private void resume(ContinueController continueController, boolean another, Runnable onDone) {
        continueController.resume(another);
        onDone.run();
    }
}
