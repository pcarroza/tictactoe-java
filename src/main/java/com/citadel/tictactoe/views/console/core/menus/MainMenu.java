package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.console.core.commands.LoadGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ProfileCommand;
import com.citadel.tictactoe.views.console.core.commands.ReplayGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowAchievementsCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowStatsCommand;

public class MainMenu extends Menu {

    private LoadGameCommand loadGameCommand;

    private ReplayGameCommand replayGameCommand;

    private ShowStatsCommand showStatsCommand;

    private ProfileCommand profileCommand;

    private ShowAchievementsCommand showAchievementsCommand;

    public MainMenu() {
        super("Menú Principal");
    }

    @Override
    public void setCommand() {
        commands.add(new GameMenu());
        loadGameCommand = new LoadGameCommand();
        commands.add(loadGameCommand);
        replayGameCommand = new ReplayGameCommand();
        commands.add(replayGameCommand);
        showStatsCommand = new ShowStatsCommand();
        commands.add(showStatsCommand);
        profileCommand = new ProfileCommand();
        commands.add(profileCommand);
        showAchievementsCommand = new ShowAchievementsCommand();
        commands.add(showAchievementsCommand);
    }

    public void setLoadGame(Feature feature) {
        loadGameCommand.setLoadGame(feature);
    }

    public void setReplay(Feature feature) {
        replayGameCommand.setReplay(feature);
    }

    public void setShowStats(Feature feature) {
        showStatsCommand.setShowStats(feature);
    }

    public void setProfile(Feature feature) {
        profileCommand.setProfile(feature);
    }

    public void setShowAchievements(Feature feature) {
        showAchievementsCommand.setShowAchievements(feature);
    }
}
