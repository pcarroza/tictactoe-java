package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationControllerBuilder;
import main.controllers.features.game.OperationController;
import main.models.features.game.Observer;
import main.models.features.game.Game;
import main.controllers.Logic;

public class LocalLogic implements Logic, Observer {

    private State actualState;

    public LocalLogic() {
        Game game = new Game(this);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        actualState = new StatesBuilder(builder).getInitialState();
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
    public OperationController getController() {
        return actualState.getController();
    }
}
