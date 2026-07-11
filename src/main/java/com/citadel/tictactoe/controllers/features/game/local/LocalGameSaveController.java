package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.SaveController;
import com.citadel.tictactoe.controllers.features.game.local.builders.LocalOperationControllerBuilder;
import com.citadel.tictactoe.models.features.game.Game;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.game.GameSnapshot;

public class LocalGameSaveController extends LocalGameOperationController implements SaveController {

    private final LocalOperationControllerBuilder builder;

    private final GameRegistry gameRegistry;

    public LocalGameSaveController(Game game, LocalOperationControllerBuilder builder, GameRegistry gameRegistry) {
        super(game);
        this.builder = builder;
        this.gameRegistry = gameRegistry;
    }

    @Override
    public void save() {
        gameRegistry.save(createSnapshot());
    }

    @Override
    public void resume() {
        getGame().resume();
    }

    @Override
    public void exit() {
        getGame().exit();
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }

    private GameSnapshot createSnapshot() {
        return new GameSnapshot(
                getGame().getPositions(),
                getGame().getIndexCurrentPlayer(),
                builder.getUsers(),
                builder.getGameId(),
                getGame().getMoveHistory().copy());
    }
}
