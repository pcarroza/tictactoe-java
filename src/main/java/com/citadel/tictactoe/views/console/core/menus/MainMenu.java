package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.console.core.commands.LoadGameCommand;
import com.citadel.tictactoe.views.console.core.commands.ShowStatsCommand;

public class MainMenu extends Menu {

    private LoadGameCommand loadGameCommand;

    private ShowStatsCommand showStatsCommand;

    public MainMenu() {
        super("Menú Principal");
    }

    @Override
    public void setCommand() {
        commands.add(new GameMenu());
        loadGameCommand = new LoadGameCommand();
        commands.add(loadGameCommand);
        showStatsCommand = new ShowStatsCommand();
        commands.add(showStatsCommand);
    }

    public void setLoadGame(Feature feature) {
        loadGameCommand.setLoadGame(feature);
    }

    public void setShowStats(Feature feature) {
        showStatsCommand.setShowStats(feature);
    }
}
