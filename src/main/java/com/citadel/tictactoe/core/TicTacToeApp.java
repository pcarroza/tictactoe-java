package com.citadel.tictactoe.core;

import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.core.config.LogicType;
import com.citadel.tictactoe.core.config.ViewType;
import com.citadel.tictactoe.core.features.*;
import com.citadel.tictactoe.views.console.core.menus.MainMenu;

public class TicTacToeApp {

    public static void main(String[] args) {
        AppConfig.set(LogicType.LOCAL, ViewType.CONSOLE);
        EventWiring.wire();
        MainMenu menu = new MainMenu();
        menu.set(new GameFeature());
        menu.setLoadGame(new LoadFeature());
        menu.setReplay(new ReplayFeature());
        menu.setShowStats(new StatisticsFeature());
        menu.setProfile(new ProfileFeature());
        menu.execute();
    }
}