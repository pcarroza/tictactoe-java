package main.controllers.features.game;

public interface SaveController extends OperationController {

    void save();

    void resume();

    void exit();
}
