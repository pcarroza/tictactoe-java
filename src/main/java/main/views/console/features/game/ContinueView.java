package main.views.console.features.game;

import main.controllers.features.game.ContinueController;
import main.shared.YesNoDialog;

public class ContinueView {
    public void interact(ContinueController continueController) {
        continueController.resume(YesNoDialog.instance().read("¿Desea Continuar?"));
    }
}
