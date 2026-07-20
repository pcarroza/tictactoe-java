package com.citadel.tictactoe.views.console.core;

public interface Module {

    void run();

    default boolean isAvailable() {
        return true;
    }
}
