package main.controllers.modules.game.local;

import main.models.Game;
import main.utils.ClosedInterval;

public class LocalOperationControllerBuilder {

    private LocalStartController localStartController;

    private LocalPlacementControllerBuilder[] builders;

    private LocalContinueController localContinueController;
    
    private final Game game;
    
    public LocalOperationControllerBuilder(Game game) {
        this.game = game;
    }

    public void build() {
        localStartController = new LocalStartController(game, this);
        builders = new LocalPlacementControllerBuilder[game.getNumberOfPlayers()];
        localContinueController = new LocalContinueController(game);
    }

    void build(int users) {
        assert new ClosedInterval<>(0, game.getNumberOfPlayers()).isIncluded(users);
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            if (i < users) {
                builders[i] = new LocalUserPlacementControllerBuilder(game);
            } else {
                builders[i] = new LocalRandomPlacementControllerBuilder(game);
            }
            builders[i].buildPlacementController();
        }
    }

    public LocalPlacementController getPlacementController() {
        assert builders != null;
        assert builders[game.getIndexCurrentPlayer()] != null;
        return builders[game.getIndexCurrentPlayer()].getPlacementController();
    }

    public LocalContinueController getContinueController() {
        return localContinueController;
    }

    public LocalStartController getStartController() {
        return localStartController;
    }
}
