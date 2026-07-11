package com.citadel.tictactoe.views.javafx.features.game;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReportVisitor;
import com.citadel.tictactoe.controllers.features.game.errors.NotEmptyErrorReport;
import com.citadel.tictactoe.controllers.features.game.errors.NotPropertyErrorReport;
import com.citadel.tictactoe.controllers.features.game.errors.RepeatedCoordinateErrorReport;

class JavaFxErrorMessages implements ErrorReportVisitor {

    private String message;

    static String of(ErrorReport errorReport) {
        JavaFxErrorMessages messages = new JavaFxErrorMessages();
        errorReport.accept(messages);
        return messages.message;
    }

    @Override
    public void visit(NotEmptyErrorReport notEmptyErrorReport) {
        message = "Esa casilla está ocupada.";
    }

    @Override
    public void visit(NotPropertyErrorReport notPropertyErrorReport) {
        message = "Esa casilla no es tuya.";
    }

    @Override
    public void visit(RepeatedCoordinateErrorReport repeatedCoordinateErrorReport) {
        message = "No podés poner donde acabás de quitar.";
    }
}
