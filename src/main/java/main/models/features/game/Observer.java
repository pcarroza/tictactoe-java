package main.models.features.game;

public interface Observer {

    void initialize();

    void begin();

    void end();

    void exit();

    void save();

    void resume();
}
