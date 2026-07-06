package com.citadel.tictactoe.controllers.features.game.local.builders;

import com.citadel.tictactoe.controllers.features.game.local.*;
import com.citadel.tictactoe.controllers.features.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.models.features.game.Game;
import com.citadel.tictactoe.shared.ClosedInterval;

import java.util.Arrays;

public class LocalOperationControllerBuilder {

    private LocalPlacementControllerBuilder[] builders;

    private LocalGameStartController localStartController;

    private LocalGameContinueController localContinueController;

    private LocalGameSaveController localSaveController;

    private LocalGameUndoController localUndoController;

    private LocalGameRedoController localRedoController;

    private final Game game;

    private final int gameId;

    private int numUsers;

    public LocalOperationControllerBuilder(Game game, int gameId) {
        this.game = game;
        this.gameId = gameId;
    }

    public int getUsers() {
        return numUsers;
    }

    public int getGameId() {
        return gameId;
    }

    public void build() {
        localStartController = new LocalGameStartController(game, this);
        builders = new LocalPlacementControllerBuilder[game.getNumberOfPlayers()];
        localContinueController = new LocalGameContinueController(game);
        localSaveController = new LocalGameSaveController(game, this);
        localUndoController = new LocalGameUndoController(game);
        localRedoController = new LocalGameRedoController(game);
    }

    public void build(int users, AiDifficulty difficulty) {
        assert new ClosedInterval<>(0, game.getNumberOfPlayers()).isIncluded(users);
        this.numUsers = users;
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            if (i < users) {
                builders[i] = new LocalUserPlacementControllerBuilder(game);
            } else {
                builders[i] = new LocalAiPlacementControllerBuilder(game, difficulty);
            }
            builders[i].buildPlacementController();
        }
    }

    public LocalGamePlacementController getPlacementController() {
        assert builders != null;
        Arrays.stream(builders).forEach(controller -> {
            assert controller != null;
        });
        return builders[game.getIndexCurrentPlayer()].getPlacementController();
    }

    public LocalGameContinueController getContinueController() {
        return localContinueController;
    }

    public LocalGameStartController getStartController() {
        return localStartController;
    }

    public LocalGameSaveController getSaveController() {
        return localSaveController;
    }

    public LocalGameUndoController getUndoController() {
        return localUndoController;
    }

    public LocalGameRedoController getRedoController() {
        return localRedoController;
    }
}

