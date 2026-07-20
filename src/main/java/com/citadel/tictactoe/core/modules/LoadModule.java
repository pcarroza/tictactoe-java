package com.citadel.tictactoe.core.modules;

import com.citadel.tictactoe.controllers.modules.load.local.LocalLoadController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.game.GameRegistry;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.views.console.core.Module;
import com.citadel.tictactoe.views.core.LoadView;

public class LoadModule implements Module {

    private final GameRegistry gameRegistry;

    public LoadModule(GameRegistry gameRegistry) {
        this.gameRegistry = gameRegistry;
    }

    @Override
    public void run() {
        LocalLoadController controller = new LocalLoadController(gameRegistry);
        LoadView loadView = AppConfig.viewType().createLoadView();
        loadView.interact(controller);
        GameSnapshot selected = controller.getSelected();
        if (selected != null) {
            new GameModule(selected, gameRegistry).run();
        }
    }

    @Override
    public boolean isAvailable() {
        return gameRegistry.size() > 0;
    }
}
