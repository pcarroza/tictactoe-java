package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.commands.LoadGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ProfileCommand;
import com.citadel.tictactoe.views.console.core.commands.ReplayGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowAchievementsCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowStatsCommand;

public class MainMenu extends Menu {

    public MainMenu(MainMenuFeatures features) {
        super("Menú Principal");
        commands.add(new GameMenu());
        commands.add(new LoadGameCommand(features.loadFeature()));
        commands.add(new ReplayGameCommand(features.replayFeature()));
        commands.add(new ShowStatsCommand(features.statsFeature()));
        commands.add(new ProfileCommand(features.profileFeature()));
        commands.add(new ShowAchievementsCommand(features.achievementsFeature()));
    }
}
