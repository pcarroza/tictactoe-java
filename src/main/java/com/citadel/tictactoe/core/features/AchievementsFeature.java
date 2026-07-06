package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.achievements.local.LocalAchievementsController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.AchievementsView;

public class AchievementsFeature implements Feature {

    @Override
    public void run() {
        LocalAchievementsController controller = new LocalAchievementsController();
        AchievementsView view = AppConfig.viewType().createAchievementsView();
        view.interact(controller);
    }
}
