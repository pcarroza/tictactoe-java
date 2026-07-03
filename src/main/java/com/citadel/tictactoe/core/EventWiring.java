package com.citadel.tictactoe.core;

import com.citadel.tictactoe.events.EventManager;
import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.features.game.events.GameEndedEvent;
import com.citadel.tictactoe.models.features.statistics.Statistics;

public class EventWiring {

    public static void wire() {
        EventManager.getInstance().subscribe(GameEndedEvent.class,
                event -> Statistics.getInstance().recordWin(event.winner()));

        EventManager.getInstance().subscribe(GameEndedEvent.class,
                event -> GameHistoryRegistry.getInstance().record(event.history()));
    }
}
