package main.core.features;

import main.controllers.features.load.local.LocalLoadController;
import main.core.config.AppConfig;
import main.models.features.game.GameSnapshot;
import main.views.console.core.Feature;
import main.views.core.LoadView;

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
