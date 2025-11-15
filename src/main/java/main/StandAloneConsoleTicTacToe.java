package main;

import main.controllers.modules.game.local.logic.LocalLogic;
import main.views.console.modules.game.ConsoleView;

public class StandAloneConsoleTicTacToe extends TicTacToe {

    @Override
    protected Logic getLogic() {
        return new LocalLogic();
    }

    @Override
    protected View getView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new StandAloneConsoleTicTacToe().run();
    }
}
