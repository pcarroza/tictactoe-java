package com.citadel.tictactoe.controllers.features.game.local.builders;

import com.citadel.tictactoe.controllers.features.game.local.LocalAiCoordinateController;
import com.citadel.tictactoe.controllers.features.game.local.LocalCoordinateController;
import com.citadel.tictactoe.controllers.features.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.controllers.features.game.local.ai.AiStrategy;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalAiPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    private final AiDifficulty difficulty;

    LocalAiPlacementControllerBuilder(Game game, AiDifficulty difficulty) {
        super(game);
        assert difficulty != null;
        this.difficulty = difficulty;
    }

    @Override
    public void buildPlacementController() {
        AiStrategy strategy = difficulty.createStrategy();
        LocalCoordinateController[] controllers = {
                new LocalAiCoordinateController(super.game, strategy),
                new LocalAiCoordinateController(super.game, strategy)
        };
        super.buildPlacementController(controllers);
    }
}
