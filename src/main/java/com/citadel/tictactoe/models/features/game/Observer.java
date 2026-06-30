package com.citadel.tictactoe.models.features.game;

public interface Observer {

    void initialize();

    void begin();

    void end();

    void exit();

    void save();

    void resume();

    void undo();

    void redo();
}
