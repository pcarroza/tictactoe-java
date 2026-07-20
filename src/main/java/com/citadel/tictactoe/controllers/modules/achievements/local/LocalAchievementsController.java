package com.citadel.tictactoe.controllers.modules.achievements.local;

import com.citadel.tictactoe.controllers.modules.achievements.AchievementsController;
import com.citadel.tictactoe.models.modules.achievements.Achievement;
import com.citadel.tictactoe.models.modules.achievements.AchievementTracker;

public class LocalAchievementsController implements AchievementsController {

    private final AchievementTracker achievementTracker;

    public LocalAchievementsController(AchievementTracker achievementTracker) {
        this.achievementTracker = achievementTracker;
    }

    @Override
    public boolean isUnlocked(Achievement achievement) {
        return achievementTracker.getUnlocked().contains(achievement);
    }
}
