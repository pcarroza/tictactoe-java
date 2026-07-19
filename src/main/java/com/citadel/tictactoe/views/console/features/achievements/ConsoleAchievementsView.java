package com.citadel.tictactoe.views.console.features.achievements;

import com.citadel.tictactoe.controllers.features.achievements.AchievementsController;
import com.citadel.tictactoe.models.features.achievements.Achievement;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.AchievementsView;

public class ConsoleAchievementsView implements AchievementsView {

    @Override
    public void interact(AchievementsController controller) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("  === LOGROS ===");
        terminal.writeln();
        for (Achievement achievement : Achievement.values()) {
            String mark = controller.isUnlocked(achievement) ? "[X]" : "[ ]";
            terminal.writeln("  " + mark + " " + achievement.getTitle() + " - " + achievement.getDescription());
        }
        terminal.writeln();
        terminal.writeln("  [1] Volver");
        terminal.writeln();
        new LimitedIntDialog().read("  Selecciona una opción", 1);
    }
}
