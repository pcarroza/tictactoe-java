package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public class ProfileCommand extends Command {

    private final Module module;

    public ProfileCommand(Module module) {
        super("Perfiles de Jugador");
        this.module = module;
    }

    @Override
    public void execute() {
        module.run();
    }
}
