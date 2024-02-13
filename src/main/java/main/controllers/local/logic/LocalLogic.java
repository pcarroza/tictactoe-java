package main.controllers.local.logic;

import main.controllers.local.LocalOperationControllerBuilder;
import main.controllers.OperationController;
import main.models.Observer;
import main.models.Game;
import main.Logic;

public class LocalLogic implements Logic, Observer {

    private State actualState;

    public LocalLogic() {
        Game game = new Game(this);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        this.actualState = new StatesBuilder(builder).getInitialState();
    }

    @Override
    public void initialize() {
        this.actualState = this.actualState.initialize();
    }

    @Override
    public void begin() {
        this.actualState = this.actualState.begin();
    }

    @Override
    public void end() {
        this.actualState = this.actualState.end();
    }

    @Override
    public void exit() {
        this.actualState = this.actualState.exit();
    }

    @Override
    public OperationController getController() {
        return this.actualState.getController();
    }
}
