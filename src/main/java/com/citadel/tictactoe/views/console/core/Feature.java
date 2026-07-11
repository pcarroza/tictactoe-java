package com.citadel.tictactoe.views.console.core;

public interface Feature {

    void run();

    default boolean isAvailable() {
        return true;
    }
}
