package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.load.local.LocalLoadController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.LoadView;

public class LoadFeature implements Feature {

    private final GameRegistry gameRegistry;

    public LoadFeature(GameRegistry gameRegistry) {
        this.gameRegistry = gameRegistry;
    }

    @Override
    public void run() {
        LocalLoadController controller = new LocalLoadController(gameRegistry);
        LoadView loadView = AppConfig.viewType().createLoadView();
        loadView.interact(controller);
        GameSnapshot selected = controller.getSelected();
        if (selected != null) {
            new GameFeature(selected, gameRegistry).run();
        }
    }

    @Override
    public boolean isAvailable() {
        return gameRegistry.size() > 0;
    }
}
