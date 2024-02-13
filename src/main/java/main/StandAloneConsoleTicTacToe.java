package main;

import main.controllers.local.LocalRandomCoordinateController;
import main.controllers.local.logic.LocalLogic;
import main.views.console.ConsoleView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
