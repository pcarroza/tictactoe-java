package com.citadel.tictactoe.models.modules.achievements;

import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.modules.game.events.GameEndedEvent;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AchievementTrackerTest {

    private AchievementTracker tracker;

    @Before
    public void setUp() {
        tracker = new AchievementTracker();
    }

    @Test
    public void givenFreshTracker_whenFirstGameEnds_thenFirstWinIsUnlocked() {
        endGame(Player.XS);

        assertThat(tracker.getUnlocked().contains(Achievement.FIRST_WIN), is(true));
    }

    @Test
    public void givenFreshTracker_whenFirstGameEnds_thenNoOtherAchievementIsUnlocked() {
        endGame(Player.XS);

        assertThat(tracker.getUnlocked().contains(Achievement.WIN_STREAK_3), is(false));
        assertThat(tracker.getUnlocked().contains(Achievement.VETERAN_10_GAMES), is(false));
    }

    @Test
    public void givenSamePlayerWinsThreeTimesInARow_whenThirdGameEnds_thenWinStreak3IsUnlocked() {
        endGame(Player.XS);
        endGame(Player.XS);
        endGame(Player.XS);

        assertThat(tracker.getUnlocked().contains(Achievement.WIN_STREAK_3), is(true));
    }

    @Test
    public void givenStreakInterruptedThenRebuilt_whenThirdConsecutiveWinHappensAgain_thenWinStreak3IsUnlocked() {
        endGame(Player.OS);
        endGame(Player.XS);
        endGame(Player.OS);
        endGame(Player.OS);

        assertThat(tracker.getUnlocked().contains(Achievement.WIN_STREAK_3), is(false));

        endGame(Player.OS);

        assertThat(tracker.getUnlocked().contains(Achievement.WIN_STREAK_3), is(true));
    }

    @Test
    public void givenTenGamesEnded_whenTenthGameEnds_thenVeteran10GamesIsUnlocked() {
        for (int i = 0; i < 9; i++) {
            endGame(i % 2 == 0 ? Player.XS : Player.OS);
        }

        assertThat(tracker.getUnlocked().contains(Achievement.VETERAN_10_GAMES), is(false));

        endGame(Player.XS);

        assertThat(tracker.getUnlocked().contains(Achievement.VETERAN_10_GAMES), is(true));
    }

    @Test
    public void givenNoPriorWinner_whenFirstGameEnds_thenNoNullPointerException() {
        endGame(Player.OS);
    }

    private void endGame(Player winner) {
        tracker.onGameEnded(new GameEndedEvent(winner, new MoveHistory()));
    }
}
