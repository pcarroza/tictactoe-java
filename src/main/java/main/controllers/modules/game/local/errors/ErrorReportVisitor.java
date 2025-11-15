package main.controllers.modules.game.local.errors;

public interface ErrorReportVisitor {

    void visit(NotEmptyErrorReport notEmptyErrorReport);

    void visit(NotPropertyErrorReport notPropertyErrorReport);

    void visit(RepeatedCoordinateErrorReport repeatedCoordinateErrorReport);
}
