package main.views.console.core.menus;

import main.controllers.Logic;
import main.controllers.features.game.OperationController;
import main.views.console.core.Feature;
import main.views.core.View;

public class StartGameCommand extends Command {

    public StartGameCommand() {
        super("Iniciar Juego");
    }

    @Override
    public void execute(Feature feature) {
        feature.run();
    }
}
