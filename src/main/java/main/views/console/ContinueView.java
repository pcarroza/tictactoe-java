package main.views.console;

import main.common.utils.YesNoDialog;
import main.controllers.ContinueController;

public class ContinueView {

    public void interact(ContinueController continueController) {
        continueController.resume(YesNoDialog.instance().read("¿Desea Continuar?"));
    }
}
