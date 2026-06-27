package main.views.core;

import main.controllers.features.load.LoadController;
import main.controllers.features.load.LoadControllerVisitor;

public interface LoadView extends LoadControllerVisitor {

    void interact(LoadController controller);
}
