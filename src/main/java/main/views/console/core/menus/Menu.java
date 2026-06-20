package main.views.console.core.menus;

import main.shared.LimitedIntDialog;
import main.shared.Terminal;
import main.views.console.core.Feature;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    protected final List<Command> commands;

    private ExitCommand exitCommand;

    public Menu() {
        this.commands = new ArrayList<>();
        this.exitCommand = new ExitCommand();
    }

    public abstract void setCommand();

    public void execute(Feature feature) {
        this.commands.clear();
        this.setCommand();
        this.commands.add(exitCommand);
        this.exitCommand.reset();
        do {
            show();
            int option = LimitedIntDialog.instance().read("Selecciona una opción", commands.size());
            commands.get(option - 1).execute(feature);
        } while (!exitCommand.closed());
    }

    private void show() {
        Terminal terminal = Terminal.getInstance();
        terminal.writeln();
        for (int i = 0; i < commands.size(); i++) {
            terminal.writeln("[" + (i + 1) + "] " + commands.get(i).getTitle());
        }
    }
}
