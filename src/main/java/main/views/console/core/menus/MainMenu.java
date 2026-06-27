package main.views.console.core.menus;

import main.views.console.core.Feature;
import main.views.console.core.commands.LoadGameCommand;

public class MainMenu extends Menu {

    private LoadGameCommand loadGameCommand;

    public MainMenu() {
        super("Menú Principal");
    }

    @Override
    public void setCommand() {
        commands.add(new GameMenu());
        loadGameCommand = new LoadGameCommand();
        commands.add(loadGameCommand);
    }

    public void setLoadGame(Feature feature) {
        loadGameCommand.setLoadGame(feature);
    }
}
