package com.citadel.tictactoe.models.features.achievements;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.game.events.GameEndedEvent;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class AchievementTracker {

    private final EnumSet<Achievement> unlocked = EnumSet.noneOf(Achievement.class);

    private final Map<Player, Integer> streaks = new EnumMap<>(Player.class);

    private int gamesPlayed;

    private Player lastWinner;

    public void onGameEnded(GameEndedEvent event) {
        gamesPlayed++;
        updateStreak(event.winner());
        evaluate();
    }

    private void updateStreak(Player winner) {
        int current = winner.equals(lastWinner) ? streaks.getOrDefault(winner, 0) + 1 : 1;
        streaks.put(winner, current);
        lastWinner = winner;
    }

    private void evaluate() {
        if (gamesPlayed == 1) {
            unlocked.add(Achievement.FIRST_WIN);
        }
        if (streaks.values().stream().anyMatch(count -> count >= 3)) {
            unlocked.add(Achievement.WIN_STREAK_3);
        }
        if (gamesPlayed >= 10) {
            unlocked.add(Achievement.VETERAN_10_GAMES);
        }
    }

    public Set<Achievement> getUnlocked() {
        return EnumSet.copyOf(unlocked);
    }
}
