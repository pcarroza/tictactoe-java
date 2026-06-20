package main.views.console.core.menus;

public class GameMenu extends Menu {

    @Override
    public void setCommand() {
        commands.add(new StartGameCommand());
    }
}
