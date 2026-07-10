package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.Feature;

public record MainMenuFeatures(
        Feature loadFeature,
        Feature replayFeature,
        Feature statsFeature,
        Feature profileFeature,
        Feature achievementsFeature) {
}
