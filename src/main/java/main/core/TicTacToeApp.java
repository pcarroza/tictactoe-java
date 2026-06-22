package main.core;

import main.core.config.AppConfig;
import main.core.config.LogicType;
import main.core.config.ViewType;
import main.core.features.GameFeature;
import main.views.console.core.menus.GameMenu;

public class TicTacToeApp {

    public static void main(String[] args) {
        AppConfig.set(LogicType.LOCAL, ViewType.CONSOLE);
        new GameMenu().execute(new GameFeature());
    }
}
