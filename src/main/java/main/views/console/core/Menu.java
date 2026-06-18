package main.views.console.core;

import main.shared.LimitedIntDialog;
import main.shared.Terminal;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    protected final List<Command> commands;

    private boolean closed;

    public Menu() {
        this.commands = new ArrayList<>();
        this.commands.add(new ExitCommand(this));
        this.closed = false;
    }

    public abstract void setCommand();

    public void run() {
        do {
            show();
            int selection = LimitedIntDialog.instance().read("Selecciona una opción", commands.size());
            commands.get(selection - 1).execute();
        } while (!closed);
    }

    void close() {
        this.closed = true;
    }

    private void show() {
        Terminal terminal = Terminal.getInstance();
        terminal.writeln();
        for (int i = 0; i < commands.size(); i++) {
            terminal.writeln("[" + (i + 1) + "] " + commands.get(i).getTitle());
        }
    }
}
