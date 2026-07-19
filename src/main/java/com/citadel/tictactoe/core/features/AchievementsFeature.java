package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.achievements.local.LocalAchievementsController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.achievements.AchievementTracker;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.AchievementsView;

public class AchievementsFeature implements Feature {

    private final AchievementTracker achievementTracker;

    public AchievementsFeature(AchievementTracker achievementTracker) {
        this.achievementTracker = achievementTracker;
    }

    @Override
    public void run() {
        LocalAchievementsController controller = new LocalAchievementsController(achievementTracker);
        AchievementsView achievementsView = AppConfig.viewType().createAchievementsView();
        achievementsView.interact(controller);
    }
}
