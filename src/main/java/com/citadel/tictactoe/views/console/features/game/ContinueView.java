package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.ContinueController;
import com.citadel.tictactoe.shared.YesNoDialog;

public class ContinueView {
    
    public void interact(ContinueController continueController) {
        continueController.resume(YesNoDialog.instance().read("¿Desea Continuar?"));
    }
}
