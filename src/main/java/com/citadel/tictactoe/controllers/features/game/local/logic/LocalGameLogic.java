package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.Logic;
import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.controllers.features.game.local.builders.LocalOperationControllerBuilder;
import com.citadel.tictactoe.models.features.game.Game;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.models.features.game.Observer;

public class LocalGameLogic implements Logic, Observer {

    private GameState actualState;

    public LocalGameLogic() {
        Game game = new Game(this);
        int gameId = GameRegistry.getInstance().nextId();
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game, gameId);
        builder.build();
        actualState = new GameStatesBuilder(builder).getInitialState();
    }

    public LocalGameLogic(GameSnapshot snapshot) {
        Game game = new Game(this);
        game.restore(snapshot);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game, snapshot.gameId());
        builder.build();
        builder.build(snapshot.getNumberUsers());
        actualState = new GameStatesBuilder(builder).getInGameState();
    }

    @Override
    public void initialize() {
        actualState = actualState.initialize();
    }

    @Override
    public void begin() {
        actualState = actualState.begin();
    }

    @Override
    public void end() {
        actualState = actualState.end();
    }

    @Override
    public void exit() {
        actualState = actualState.exit();
    }

    @Override
    public void save() {
        actualState = actualState.save();
    }

    @Override
    public void resume() {
        actualState = actualState.resume();
    }

    @Override
    public void undo() {
        actualState = actualState.undo();
    }

    @Override
    public void redo() {
        actualState = actualState.redo();
    }

    @Override
    public GameOperationController getController() {
        return actualState.getController();
    }
}
