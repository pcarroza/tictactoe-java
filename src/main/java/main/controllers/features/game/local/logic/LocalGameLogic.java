package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationControllerBuilder;
import main.controllers.features.game.OperationController;
import main.models.features.game.Observer;
import main.models.features.game.Game;
import main.models.features.game.GameSnapshot;
import main.controllers.Logic;

public class LocalGameLogic implements Logic, Observer {

    private GameState actualState;

    public LocalGameLogic() {
        Game game = new Game(this);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        actualState = new GameStatesBuilder(builder).getInitialState();
    }

    public LocalGameLogic(GameSnapshot snapshot) {
        Game game = new Game(this);
        game.restore(snapshot);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        builder.build(snapshot.getNumUsers());
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
    public OperationController getController() {
        return actualState.getController();
    }
}
