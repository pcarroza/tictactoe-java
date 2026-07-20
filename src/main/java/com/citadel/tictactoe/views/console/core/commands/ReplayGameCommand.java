package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public class ReplayGameCommand extends Command {

    private final Module module;

    public ReplayGameCommand(Module module) {
        super("Reproducir Partida");
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
