package com.citadel.tictactoe.core;

import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.core.config.LogicType;
import com.citadel.tictactoe.core.config.ViewType;
import com.citadel.tictactoe.core.features.GameFeature;
import com.citadel.tictactoe.core.features.LoadFeature;
import com.citadel.tictactoe.core.features.StatisticsFeature;
import com.citadel.tictactoe.views.console.core.menus.MainMenu;

public class TicTacToeApp {

    public static void main(String[] args) {
        AppConfig.set(LogicType.LOCAL, ViewType.CONSOLE);
        MainMenu menu = new MainMenu();
        menu.set(new GameFeature());
        menu.setLoadGame(new LoadFeature());
        menu.setShowStats(new StatisticsFeature());
        menu.execute();
    }
}