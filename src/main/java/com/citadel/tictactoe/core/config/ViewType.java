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
import com.citadel.tictactoe.views.console.core.ConsoleContext;
import com.citadel.tictactoe.views.core.*;
import com.citadel.tictactoe.views.javafx.features.game.JavaFxGameView;

public enum ViewType {

    CONSOLE {
        @Override
        public GameView createGameView(ConsoleContext consoleContext) {
            return new DebugView(new TimestampedView(new TurnNumberedView(new ConsoleGameView(consoleContext))));
        }

        @Override
        public LoadView createLoadView(ConsoleContext consoleContext) {
            return new ConsoleLoadView(consoleContext);
        }

        @Override
        public StatisticsView createStatisticsView(ConsoleContext consoleContext) {
            return new ConsoleStatisticsView(consoleContext);
        }

        @Override
        public ReplayView createReplayView(ConsoleContext consoleContext) {
            return new ConsoleReplayView(consoleContext);
        }

        @Override
        public SelectReplayView createSelectReplayView(ConsoleContext consoleContext) {
            return new ConsoleSelectReplayView(consoleContext);
        }

        @Override
        public ProfileView createProfileView(ConsoleContext consoleContext) {
            return new ConsoleProfileView(consoleContext);
        }

        @Override
        public AchievementsView createAchievementsView(ConsoleContext consoleContext) {
            return new ConsoleAchievementsView(consoleContext);
        }
    },

    JAVAFX {
        @Override
        public GameView createGameView(ConsoleContext consoleContext) {
            return new JavaFxGameView();
        }

        @Override
        public LoadView createLoadView(ConsoleContext consoleContext) {
            assert false;
            return null;
        }

        @Override
        public StatisticsView createStatisticsView(ConsoleContext consoleContext) {
            assert false;
            return null;
        }

        @Override
        public ReplayView createReplayView(ConsoleContext consoleContext) {
            assert false;
            return null;
        }

        @Override
        public SelectReplayView createSelectReplayView(ConsoleContext consoleContext) {
            assert false;
            return null;
        }

        @Override
        public ProfileView createProfileView(ConsoleContext consoleContext) {
            assert false;
            return null;
        }

        @Override
        public AchievementsView createAchievementsView(ConsoleContext consoleContext) {
            assert false;
            return null;
        }
    };

    public abstract GameView createGameView(ConsoleContext consoleContext);

    public abstract LoadView createLoadView(ConsoleContext consoleContext);

    public abstract StatisticsView createStatisticsView(ConsoleContext consoleContext);

    public abstract ReplayView createReplayView(ConsoleContext consoleContext);

    public abstract SelectReplayView createSelectReplayView(ConsoleContext consoleContext);

    public abstract ProfileView createProfileView(ConsoleContext consoleContext);

    public abstract AchievementsView createAchievementsView(ConsoleContext consoleContext);
}
