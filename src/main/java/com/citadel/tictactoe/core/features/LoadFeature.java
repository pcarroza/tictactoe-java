package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.load.local.LocalLoadController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.game.GameSnapshot;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.LoadView;

public class LoadFeature implements Feature {

    @Override
    public void run() {
        LocalLoadController controller = new LocalLoadController();
        LoadView view = AppConfig.viewType().createLoadView();
        view.interact(controller);
        GameSnapshot selected = controller.getSelected();
        if (selected != null) {
            new GameFeature(selected).run();
        }
    }
}
