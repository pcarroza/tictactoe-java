package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.Module;

public record MainMenuModules(
        Module loadModule,
        Module replayModule,
        Module statsModule,
        Module profileModule,
        Module achievementsModule) {
}
