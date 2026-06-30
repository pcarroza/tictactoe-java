package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationController;
import main.controllers.features.game.local.LocalOperationControllerBuilder;
import main.controllers.features.game.local.LocalSaveController;

class SaveMenuState extends GameState {

    private final LocalSaveController localSaveController;

    SaveMenuState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.localSaveController = builder.getSaveController();
    }

    @Override
    GameState resume() {
        return statesBuilder.getInGameState();
    }

    @Override
    GameState exit() {
        return statesBuilder.getExistState();
    }

    @Override
    LocalOperationController getController() {
        return localSaveController;
    }
}
