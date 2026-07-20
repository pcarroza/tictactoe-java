package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public class ShowStatsCommand extends Command {

    private final Module module;

    public ShowStatsCommand(Module module) {
        super("Estadísticas");
        this.module = module;
    }

    @Override
    public boolean isAvailable() {
        return module.isAvailable();
    }

    @Override
    public void execute() {
        module.run();
    }
}
