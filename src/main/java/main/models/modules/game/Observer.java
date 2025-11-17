package main.models.modules.game;

public interface Observer {

    void initialize();

    void begin();

    void end();

    void exit();
}
