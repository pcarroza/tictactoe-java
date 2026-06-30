package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.console.core.commands.Command;
import com.citadel.tictactoe.views.console.core.commands.ExitCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Menu extends Command {

    protected final List<Command> commands;

    private final ExitCommand exitCommand;

    protected Menu(String title) {
        super(title);
        this.commands = new ArrayList<>();
        this.setCommand();
        this.exitCommand = new ExitCommand();
        this.commands.add(exitCommand);
    }

    public abstract void setCommand();

    @Override
    public void set(Feature feature) {
        for (Command command : commands) {
            command.set(feature);
        }
    }

    @Override
    public void execute() {
        exitCommand.reset();
        do {
            List<Command> available = availableCommands();
            writeln(available);
            int option = LimitedIntDialog.instance().read("Selecciona una opción", available.size());
            available.get(option - 1).execute();
        } while (!exitCommand.closed());
    }

    private List<Command> availableCommands() {
        return commands.stream().filter(Command::isAvailable).collect(Collectors.toList());
    }

    private void writeln(List<Command> available) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("  === " + getTitle().toUpperCase() + " ===");
        terminal.writeln();
        for (int i = 0; i < available.size(); i++) {
            terminal.writeln("  [" + (i + 1) + "] " + available.get(i).getTitle());
        }
        terminal.writeln();
    }
}
