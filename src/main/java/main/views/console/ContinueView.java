package main.views.console;

import main.controllers.modules.game.ContinueController;
import main.utils.YesNoDialog;

public class ContinueView {
    public void interact(ContinueController continueController) {
        continueController.resume(YesNoDialog.instance().read("¿Desea Continuar?"));
    }
}
