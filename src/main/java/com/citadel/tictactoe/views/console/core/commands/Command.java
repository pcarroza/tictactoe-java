package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Module;

public abstract class Command {

    private final String title;

    protected Command(String title) {
        this.title = title;
    }

    public void set(Module module) {
    }

    public boolean isAvailable() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();
}
