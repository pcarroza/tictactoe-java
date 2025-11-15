package main.controllers.modules.game.local.logic;

import main.controllers.modules.game.local.LocalOperationControllerBuilder;
import main.controllers.modules.game.OperationController;
import main.models.Observer;
import main.models.Game;
import main.Logic;

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
