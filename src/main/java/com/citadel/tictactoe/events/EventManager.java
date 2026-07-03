package com.citadel.tictactoe.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private static final EventManager instance = new EventManager();

    private final Map<Class<?>, List<Listener<?>>> listeners;

    private EventManager() {
        this.listeners = new HashMap<>();
    }

    public static EventManager getInstance() {
        return instance;
    }

    public <T> void subscribe(Class<T> eventType, Listener<T> listener) {
        listeners.computeIfAbsent(eventType, type -> new ArrayList<>()).add(listener);
    }

    @SuppressWarnings("unchecked")
    public <T> void publish(T event) {
        for (Listener<?> listener : listeners.getOrDefault(event.getClass(), List.of())) {
            ((Listener<T>) listener).onEvent(event);
        }
    }
}
