package main.views.console.modules.game;

import main.controllers.modules.game.errors.*;
import main.models.Coordinate;
import main.utils.Terminal;

import java.util.Iterator;

public class ErrorReportView implements ErrorReportVisitor {

    public void write(ErrorReport errorReport) {
        errorReport.accept(this);
    }

    @Override
    public void visit(NotEmptyErrorReport notEmptyErrorReport) {
        write("Esta casilla está ocupada.", notEmptyErrorReport);
    }

    @Override
    public void visit(NotPropertyErrorReport notPropertyErrorReport) {
        write("Esta casilla no está ocupada por ninguna casilla.", notPropertyErrorReport);
    }

    @Override
    public void visit(RepeatedCoordinateErrorReport repeatedCoordinateErrorReport) {
        write("No se puede poner donde se quito", repeatedCoordinateErrorReport);
    }

    private void write(String message, ErrorReport errorReport) {
        String separator = message + " Puedes optar por: ";
        Iterator<Coordinate> coordinates = errorReport.iterator();
        while (coordinates.hasNext()) {
            CoordinateView.instance().write(separator, coordinates.next());
            if (!separator.equals(", ")) {
                separator = ", ";
            }
        }
        Terminal.getInstance().writeln();
    }
}
