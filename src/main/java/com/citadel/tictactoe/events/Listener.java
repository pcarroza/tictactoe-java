package com.citadel.tictactoe.events;

public interface Listener<T> {

    void onEvent(T event);
}
