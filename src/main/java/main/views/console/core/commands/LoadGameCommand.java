package main.views.console.core.commands;

import main.views.console.core.Feature;

public class LoadGameCommand extends Command {

    private Feature feature;

    public LoadGameCommand() {
        super("Cargar Partida");
    }

    public void setLoadGame(Feature feature) {
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
