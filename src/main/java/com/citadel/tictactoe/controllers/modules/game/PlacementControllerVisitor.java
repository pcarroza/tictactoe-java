package com.citadel.tictactoe.controllers.modules.game;

public interface PlacementControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
