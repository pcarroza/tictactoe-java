package main.core.config;

import main.views.console.features.game.ConsoleView;
import main.views.core.View;

public enum ViewType {

    CONSOLE {
        @Override
        public View create() {
            return new ConsoleView();
        }
    };

    public abstract View create();
}
