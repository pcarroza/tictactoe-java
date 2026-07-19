package com.citadel.tictactoe.core.config;

import com.citadel.tictactoe.views.console.features.achievements.ConsoleAchievementsView;
import com.citadel.tictactoe.views.console.features.game.ConsoleGameView;
import com.citadel.tictactoe.views.console.features.game.decorator.DebugView;
import com.citadel.tictactoe.views.console.features.game.decorator.TimestampedView;
import com.citadel.tictactoe.views.console.features.game.decorator.TurnNumberedView;
import com.citadel.tictactoe.views.console.features.load.ConsoleLoadView;
import com.citadel.tictactoe.views.console.features.player.ConsoleProfileView;
import com.citadel.tictactoe.views.console.features.replay.ConsoleReplayView;
import com.citadel.tictactoe.views.console.features.replay.ConsoleSelectReplayView;
import com.citadel.tictactoe.views.console.features.statistics.ConsoleStatisticsView;
import com.citadel.tictactoe.views.core.*;
import com.citadel.tictactoe.views.javafx.features.game.JavaFxGameView;

public enum ViewType {

    CONSOLE {
        @Override
        public GameView createGameView() {
            return new DebugView(new TimestampedView(new TurnNumberedView(new ConsoleGameView())));
        }

        @Override
        public LoadView createLoadView() {
            return new ConsoleLoadView();
        }

        @Override
        public StatisticsView createStatisticsView() {
            return new ConsoleStatisticsView();
        }

        @Override
        public ReplayView createReplayView() {
            return new ConsoleReplayView();
        }

        @Override
        public SelectReplayView createSelectReplayView() {
            return new ConsoleSelectReplayView();
        }

        @Override
        public ProfileView createProfileView() {
            return new ConsoleProfileView();
        }

        @Override
        public AchievementsView createAchievementsView() {
            return new ConsoleAchievementsView();
        }
    },

    JAVAFX {
        @Override
        public GameView createGameView() {
            return new JavaFxGameView();
        }

        @Override
        public LoadView createLoadView() {
            assert false;
            return null;
        }

        @Override
        public StatisticsView createStatisticsView() {
            assert false;
            return null;
        }

        @Override
        public ReplayView createReplayView() {
            assert false;
            return null;
        }

        @Override
        public SelectReplayView createSelectReplayView() {
            assert false;
            return null;
        }

        @Override
        public ProfileView createProfileView() {
            assert false;
            return null;
        }

        @Override
        public AchievementsView createAchievementsView() {
            assert false;
            return null;
        }
    };

    public abstract GameView createGameView();

    public abstract LoadView createLoadView();

    public abstract StatisticsView createStatisticsView();

    public abstract ReplayView createReplayView();

    public abstract SelectReplayView createSelectReplayView();

    public abstract ProfileView createProfileView();

    public abstract AchievementsView createAchievementsView();
}
