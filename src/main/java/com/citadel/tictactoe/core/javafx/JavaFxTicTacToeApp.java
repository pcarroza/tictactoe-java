package com.citadel.tictactoe.core.javafx;

import com.citadel.tictactoe.controllers.modules.game.Logic;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.game.GameRegistry;
import com.citadel.tictactoe.views.javafx.modules.game.JavaFxGameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxTicTacToeApp extends Application {

    private static GameRegistry gameRegistry;

    public static void configure(GameRegistry gameRegistry) {
        JavaFxTicTacToeApp.gameRegistry = gameRegistry;
    }

    @Override
    public void start(Stage stage) {
        Logic logic = AppConfig.logicType().create(gameRegistry);
        JavaFxGameView gameView = (JavaFxGameView) AppConfig.viewType().createGameView();
        gameView.bind(logic, stage);
        gameView.advance();
    }
}
