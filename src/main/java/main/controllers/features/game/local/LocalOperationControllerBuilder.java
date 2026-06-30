package main.controllers.features.game.local;

import main.models.features.game.Game;
import main.shared.ClosedInterval;

import java.util.Arrays;

public class LocalOperationControllerBuilder {

    private LocalStartController localStartController;

    private LocalPlacementControllerBuilder[] builders;

    private LocalContinueController localContinueController;

    private LocalSaveController localSaveController;

    private final Game game;

    private final int gameId;

    private int numUsers;

    public LocalOperationControllerBuilder(Game game, int gameId) {
        this.game = game;
        this.gameId = gameId;
    }

    public void build() {
        localStartController = new LocalStartController(game, this);
        builders = new LocalPlacementControllerBuilder[game.getNumberOfPlayers()];
        localContinueController = new LocalContinueController(game);
        localSaveController = new LocalSaveController(game, this);
    }

    public void build(int users) {
        assert new ClosedInterval<>(0, game.getNumberOfPlayers()).isIncluded(users);
        this.numUsers = users;
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
        Arrays.stream(builders).forEach(controller -> {
            assert controller != null;
        });
        return builders[game.getIndexCurrentPlayer()].getPlacementController();
    }

    public LocalContinueController getContinueController() {
        return localContinueController;
    }

    public LocalStartController getStartController() {
        return localStartController;
    }

    public LocalSaveController getSaveController() {
        return localSaveController;
    }

    public int getGameId() {
        return gameId;
    }

    public int getUsers() {
        return numUsers;
    }

}
