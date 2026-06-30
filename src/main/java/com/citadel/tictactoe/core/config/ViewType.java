package com.citadel.tictactoe.core.config;

import com.citadel.tictactoe.views.console.features.game.ConsoleView;
import com.citadel.tictactoe.views.console.features.load.ConsoleLoadView;
import com.citadel.tictactoe.views.console.features.statistics.ConsoleStatisticsView;
import com.citadel.tictactoe.views.core.LoadView;
import com.citadel.tictactoe.views.core.StatisticsView;
import com.citadel.tictactoe.views.core.View;

public enum ViewType {

    CONSOLE {
        @Override
        public View create() {
            return new ConsoleView();
        }

        @Override
        public LoadView createLoadView() {
            return new ConsoleLoadView();
        }

        @Override
        public StatisticsView createStatisticsView() {
            return new ConsoleStatisticsView();
        }
    };

    public abstract View create();

    public abstract LoadView createLoadView();

    public abstract StatisticsView createStatisticsView();
}
