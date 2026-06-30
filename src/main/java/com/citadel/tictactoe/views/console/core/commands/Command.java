package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public abstract class Command {

    private final String title;

    protected Command(String title) {
        this.title = title;
    }

    public void set(Feature feature) {
    }

    public boolean isAvailable() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();
}
