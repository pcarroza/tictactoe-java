package main.controllers.features.load.local;

import main.controllers.features.load.LoadController;
import main.controllers.features.load.LoadControllerVisitor;
import main.models.features.game.GameRegistry;
import main.models.features.game.GameSnapshot;

import java.util.ArrayList;
import java.util.List;

public class LocalLoadController implements LoadController {

    private GameSnapshot selected;

    @Override
    public boolean hasGames() {
        return GameRegistry.getInstance().size() > 0;
    }

    @Override
    public List<String> getGameTitles() {
        List<String> titles = new ArrayList<>();
        int size = GameRegistry.getInstance().size();
        for (int i = 0; i < size; i++) {
            titles.add("Partida " + (i + 1));
        }
        return titles;
    }

    @Override
    public void select(int index) {
        this.selected = GameRegistry.getInstance().get(index);
    }

    @Override
    public GameSnapshot getSelected() {
        return selected;
    }

    @Override
    public void accept(LoadControllerVisitor visitor) {
        visitor.visit(this);
    }
}
