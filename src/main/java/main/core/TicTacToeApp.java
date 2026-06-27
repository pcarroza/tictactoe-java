package main.core;

import main.core.config.AppConfig;
import main.core.config.LogicType;
import main.core.config.ViewType;
import main.core.features.GameFeature;
import main.core.features.LoadFeature;
import main.views.console.core.menus.MainMenu;

public class TicTacToeApp {

    public static void main(String[] args) {
        AppConfig.set(LogicType.LOCAL, ViewType.CONSOLE);
        MainMenu menu = new MainMenu();
        menu.set(new GameFeature());
        menu.setLoadGame(new LoadFeature());
        menu.execute();
    }
}