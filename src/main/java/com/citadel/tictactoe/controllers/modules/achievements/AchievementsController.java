package com.citadel.tictactoe.controllers.modules.achievements;

import com.citadel.tictactoe.models.modules.achievements.Achievement;

public interface AchievementsController {

    boolean isUnlocked(Achievement achievement);
}
