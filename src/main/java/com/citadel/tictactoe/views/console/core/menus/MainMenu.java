package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.commands.LoadGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ProfileCommand;
import com.citadel.tictactoe.views.console.core.commands.ReplayGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowAchievementsCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowStatsCommand;

public class MainMenu extends Menu {

    public MainMenu(MainMenuModules modules) {
        super("Menú Principal");
        commands.add(new GameMenu());
        commands.add(new LoadGameCommand(modules.loadModule()));
        commands.add(new ReplayGameCommand(modules.replayModule()));
        commands.add(new ShowStatsCommand(modules.statsModule()));
        commands.add(new ProfileCommand(modules.profileModule()));
        commands.add(new ShowAchievementsCommand(modules.achievementsModule()));
    }
}
