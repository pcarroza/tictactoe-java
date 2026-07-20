package com.citadel.tictactoe.core;

import com.citadel.tictactoe.events.EventManager;
import com.citadel.tictactoe.models.modules.achievements.AchievementTracker;
import com.citadel.tictactoe.models.modules.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.modules.game.events.GameEndedEvent;
import com.citadel.tictactoe.models.modules.statistics.Statistics;

public class EventWiring {

    public static void wire(Statistics statistics, GameHistoryRegistry gameHistoryRegistry, AchievementTracker achievementTracker) {
        EventManager.getInstance().subscribe(GameEndedEvent.class,
                event -> statistics.recordWin(event.winner()));

        EventManager.getInstance().subscribe(GameEndedEvent.class,
                event -> gameHistoryRegistry.record(event.history()));

        EventManager.getInstance().subscribe(GameEndedEvent.class, achievementTracker::onGameEnded);
    }
}
