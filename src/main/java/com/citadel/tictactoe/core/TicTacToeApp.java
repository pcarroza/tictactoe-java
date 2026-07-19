package com.citadel.tictactoe.core;

import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.core.config.LogicType;
import com.citadel.tictactoe.core.config.ViewType;
import com.citadel.tictactoe.core.features.*;
import com.citadel.tictactoe.core.javafx.JavaFxTicTacToeApp;
import com.citadel.tictactoe.models.features.achievements.AchievementTracker;
import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.player.ProfileRegistry;
import com.citadel.tictactoe.models.features.statistics.Statistics;
import com.citadel.tictactoe.models.persistence.PersistenceType;
import com.citadel.tictactoe.models.persistence.repository.factory.DaoFactory;
import com.citadel.tictactoe.views.console.core.menus.MainMenu;
import com.citadel.tictactoe.views.console.core.menus.MainMenuFeatures;
import javafx.application.Application;

public class TicTacToeApp {

    private static final ViewType VIEW_TYPE = ViewType.JAVAFX;

    public static void main(String[] args) {
        DaoFactory daoFactory = PersistenceType.SQLITE.createDaoFactory();
        GameRegistry gameRegistry = new GameRegistry(daoFactory.createGameDao());
        Statistics statistics = new Statistics(daoFactory.createStatisticsDao());
        GameHistoryRegistry gameHistoryRegistry = new GameHistoryRegistry();
        ProfileRegistry profileRegistry = new ProfileRegistry();
        AchievementTracker achievementTracker = new AchievementTracker();

        AppConfig.set(LogicType.LOCAL, VIEW_TYPE);
        EventWiring.wire(statistics, gameHistoryRegistry, achievementTracker);

        if (VIEW_TYPE == ViewType.JAVAFX) {
            JavaFxTicTacToeApp.configure(gameRegistry);
            Application.launch(JavaFxTicTacToeApp.class, args);
            return;
        }

        MainMenuFeatures features = new MainMenuFeatures(
                new LoadFeature(gameRegistry),
                new ReplayFeature(gameHistoryRegistry),
                new StatisticsFeature(statistics, profileRegistry),
                new ProfileFeature(profileRegistry),
                new AchievementsFeature(achievementTracker));
        MainMenu menu = new MainMenu(features);
        menu.set(new GameFeature(gameRegistry));
        menu.execute();
    }
}
