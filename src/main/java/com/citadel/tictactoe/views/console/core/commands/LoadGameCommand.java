package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public class LoadGameCommand extends Command {

    private final Module module;

    public LoadGameCommand(Module module) {
        super("Cargar Partida");
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
