package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public class ShowAchievementsCommand extends Command {

    private final Module module;

    public ShowAchievementsCommand(Module module) {
        super("Logros");
        this.module = module;
    }

    @Override
    public void execute() {
        module.run();
    }
}
