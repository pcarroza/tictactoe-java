package main.views.console.core.commands;

import main.views.console.core.Feature;

public abstract class Command {

    private final String title;

    protected Command(String title) {
        this.title = title;
    }

    public void set(Feature feature) {
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();
}
