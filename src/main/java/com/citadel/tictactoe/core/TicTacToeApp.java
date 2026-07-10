package com.citadel.tictactoe.core;

import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.core.config.LogicType;
import com.citadel.tictactoe.core.config.ViewType;
import com.citadel.tictactoe.core.features.*;
import com.citadel.tictactoe.models.persistence.Persistence;
import com.citadel.tictactoe.models.persistence.PersistenceType;
import com.citadel.tictactoe.views.console.core.menus.MainMenu;
import com.citadel.tictactoe.views.console.core.menus.MainMenuFeatures;

public class TicTacToeApp {

    public static void main(String[] args) {
        Persistence.configure(PersistenceType.SQLITE);
        AppConfig.set(LogicType.LOCAL, ViewType.CONSOLE);
        EventWiring.wire();
        MainMenuFeatures features = new MainMenuFeatures(
                new LoadFeature(),
                new ReplayFeature(),
                new StatisticsFeature(),
                new ProfileFeature(),
                new AchievementsFeature());
        MainMenu menu = new MainMenu(features);
        menu.set(new GameFeature());
        menu.execute();
    }
}