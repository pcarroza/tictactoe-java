package main.controllers.features.game.local;

import main.controllers.features.game.OperationControllerVisitor;
import main.controllers.features.game.SaveController;
import main.models.features.game.Game;
import main.models.features.game.GameRegistry;
import main.models.features.game.GameSnapshot;

public class LocalSaveController extends LocalOperationController implements SaveController {

    private final LocalOperationControllerBuilder builder;

    public LocalSaveController(Game game, LocalOperationControllerBuilder builder) {
        super(game);
        this.builder = builder;
    }

    @Override
    public void save() {
        GameRegistry.getInstance().save(createSnapshot());
    }

    @Override
    public void resume() {
        resume();
    }

    @Override
    public void exit() {
        getGame().exit();
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }

    private GameSnapshot createSnapshot() {
        return new GameSnapshot(
            getGame().getPositions(), 
            getGame().getIndexCurrentPlayer(), 
            builder.getUsers());
    }
}
