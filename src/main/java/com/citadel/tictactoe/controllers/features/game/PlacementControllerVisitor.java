package com.citadel.tictactoe.controllers.features.game;

public interface PlacementControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
