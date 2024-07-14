package main.views.console;

import main.controllers.ContinueController;
import main.common.utils.YesNoDialog;

public class ContinueView {
    public void interact(ContinueController continueController) {
        continueController.resume(YesNoDialog.instance().read("¿Desea Continuar?"));
    }
}
