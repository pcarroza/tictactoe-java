package main.core;

import main.core.features.GameFeature;
import main.views.console.core.menus.GameMenu;

public class TicTacToeApp {

    public static void main(String[] args) {
        new GameMenu().execute(new GameFeature());
    }
}
