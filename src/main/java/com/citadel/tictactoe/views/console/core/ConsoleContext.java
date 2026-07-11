package com.citadel.tictactoe.views.console.core;

import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.YesNoDialog;
import com.citadel.tictactoe.views.console.features.game.ColorView;
import com.citadel.tictactoe.views.console.features.game.CoordinateView;

public record ConsoleContext(
        ColorView colorView,
        LimitedIntDialog limitedIntDialog,
        YesNoDialog yesNoDialog,
        CoordinateView coordinateView) {
}
