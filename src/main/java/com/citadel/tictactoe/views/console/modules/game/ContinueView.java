package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.ContinueController;
import com.citadel.tictactoe.shared.YesNoDialog;

public class ContinueView {

    public void interact(ContinueController continueController) {
        continueController.resume(new YesNoDialog().read("¿Desea Continuar?"));
    }
}
