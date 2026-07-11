package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.ContinueController;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class ContinueView {

    private final ConsoleContext consoleContext;

    public ContinueView(ConsoleContext consoleContext) {
        this.consoleContext = consoleContext;
    }

    public void interact(ContinueController continueController) {
        continueController.resume(consoleContext.yesNoDialog().read("¿Desea Continuar?"));
    }
}
