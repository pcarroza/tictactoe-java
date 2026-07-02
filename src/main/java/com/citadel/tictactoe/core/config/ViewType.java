package com.citadel.tictactoe.core.config;

import com.citadel.tictactoe.views.console.features.game.ConsoleGameView;
import com.citadel.tictactoe.views.console.features.game.decorator.DebugView;
import com.citadel.tictactoe.views.console.features.game.decorator.TimestampedView;
import com.citadel.tictactoe.views.console.features.game.decorator.TurnNumberedView;
import com.citadel.tictactoe.views.console.features.load.ConsoleLoadView;
import com.citadel.tictactoe.views.console.features.replay.ConsoleReplayView;
import com.citadel.tictactoe.views.console.features.replay.ConsoleSelectReplayView;
import com.citadel.tictactoe.views.console.features.statistics.ConsoleStatisticsView;
import com.citadel.tictactoe.views.core.*;
import com.citadel.tictactoe.views.core.GameView;

public enum ViewType {

    CONSOLE {
        @Override
        public GameView create() {
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
    };

    public abstract GameView create();

    public abstract LoadView createLoadView();

    public abstract StatisticsView createStatisticsView();

    public abstract ReplayView createReplayView();

    public abstract SelectReplayView createSelectReplayView();
}
