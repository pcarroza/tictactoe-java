package main.controllers.local;

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
        this.localStartController = new LocalStartController(this.game, this);
        this.builders = new LocalPlacementControllerBuilder[this.game.getNumberOfPlayers()];
        this.localContinueController = new LocalContinueController(this.game);
    }

    void build(int users) {
        assert new ClosedInterval<>(0, this.game.getNumberOfPlayers()).isIncluded(users);
        for (int i = 0; i < this.game.getNumberOfPlayers(); i++) {
            if (i < users) {
                this.builders[i] = new LocalUserPlacementControllerBuilder(this.game);
            } else {
                this.builders[i] = new LocalRandomPlacementControllerBuilder(this.game);
            }
            this.builders[i].buildPlacementController();
        }
    }

    public LocalPlacementController getPlacementController() {
        assert this.builders != null;
        assert this.builders[this.game.getIndexCurrentPlayer()] != null;
        return this.builders[this.game.getIndexCurrentPlayer()].getPlacementController();
    }

    public LocalContinueController getContinueController() {
        return this.localContinueController;
    }

    public LocalStartController getStartController() {
        return this.localStartController;
    }
}
