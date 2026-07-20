package com.citadel.tictactoe.controllers.modules.game.local.logic;

import com.citadel.tictactoe.controllers.modules.game.Logic;
import com.citadel.tictactoe.controllers.modules.game.GameOperationController;
import com.citadel.tictactoe.controllers.modules.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.controllers.modules.game.local.builders.LocalOperationControllerBuilder;
import com.citadel.tictactoe.models.modules.game.Game;
import com.citadel.tictactoe.models.modules.game.GameRegistry;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.modules.game.Observer;

public class LocalGameLogic implements Logic, Observer {

    private GameState actualState;

    public LocalGameLogic(GameRegistry gameRegistry) {
        Game game = new Game(this);
        int gameId = gameRegistry.nextId();
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game, gameId, gameRegistry);
        builder.build();
        actualState = new GameStatesBuilder(builder).getInitialState();
    }

    public LocalGameLogic(GameSnapshot snapshot, GameRegistry gameRegistry) {
        Game game = new Game(this);
        game.restore(snapshot);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game, snapshot.gameId(), gameRegistry);
        builder.build();
        builder.build(snapshot.getNumberUsers(), AiDifficulty.EASY);
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
        return TimedControllerFactory.wrap(actualState.getController());
    }
}
