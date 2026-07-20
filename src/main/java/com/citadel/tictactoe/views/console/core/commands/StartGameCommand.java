package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public class StartGameCommand extends Command {

    private Module module;

    public StartGameCommand() {
        super("Iniciar Juego");
    }

    @Override
    public void set(Module module) {
        this.module = module;
    }

    @Override
    public void execute() {
        module.run();
    }
}
