package com.citadel.tictactoe.controllers.modules.game.local.builders;

import com.citadel.tictactoe.controllers.modules.game.local.LocalAiCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.local.LocalCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.controllers.modules.game.local.ai.AiStrategy;
import com.citadel.tictactoe.models.modules.game.Game;

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
