package main.core.config;

import main.views.console.features.game.ConsoleView;
import main.views.console.features.load.ConsoleLoadView;
import main.views.core.LoadView;
import main.views.core.View;

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
    };

    public abstract View create();

    public abstract LoadView createLoadView();
}
