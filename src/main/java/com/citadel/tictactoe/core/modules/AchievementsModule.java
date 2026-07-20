package com.citadel.tictactoe.core.modules;

import com.citadel.tictactoe.controllers.modules.achievements.local.LocalAchievementsController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.achievements.AchievementTracker;
import com.citadel.tictactoe.views.console.core.Module;
import com.citadel.tictactoe.views.core.AchievementsView;

public class AchievementsModule implements Module {

    private final AchievementTracker achievementTracker;

    public AchievementsModule(AchievementTracker achievementTracker) {
        this.achievementTracker = achievementTracker;
    }

    @Override
    public void run() {
        LocalAchievementsController controller = new LocalAchievementsController(achievementTracker);
        AchievementsView achievementsView = AppConfig.viewType().createAchievementsView();
        achievementsView.interact(controller);
    }
}
