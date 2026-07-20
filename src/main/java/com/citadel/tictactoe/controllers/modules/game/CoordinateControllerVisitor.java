package com.citadel.tictactoe.controllers.modules.game;

public interface CoordinateControllerVisitor {

    void visit(UserCoordinateController userCoordinateController);

    void visit(MachineCoordinateController machineCoordinateController);
}
