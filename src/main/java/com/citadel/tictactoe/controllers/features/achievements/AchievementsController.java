package com.citadel.tictactoe.controllers.features.achievements;

import com.citadel.tictactoe.models.features.achievements.Achievement;

public interface AchievementsController {

    boolean isUnlocked(Achievement achievement);
}
