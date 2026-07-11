package com.citadel.tictactoe.views.console.features.player;

import com.citadel.tictactoe.controllers.features.player.ProfileController;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.console.core.ConsoleContext;
import com.citadel.tictactoe.views.core.ProfileView;

public class ConsoleProfileView implements ProfileView {

    private final ConsoleContext consoleContext;

    public ConsoleProfileView(ConsoleContext consoleContext) {
        this.consoleContext = consoleContext;
    }

    @Override
    public void interact(ProfileController controller) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("  === PERFILES DE JUGADOR ===");
        terminal.writeln();
        terminal.writeln("  Jugador X : " + controller.getName(Player.XS));
        terminal.writeln("  Jugador O : " + controller.getName(Player.OS));
        terminal.writeln();
        terminal.writeln("  [1] Cambiar nombre de X");
        terminal.writeln("  [2] Cambiar nombre de O");
        terminal.writeln("  [3] Volver");
        terminal.writeln();
        int option = consoleContext.limitedIntDialog().read("  Selecciona una opción", 3);
        if (option == 1) {
            rename(controller, Player.XS, terminal);
        } else if (option == 2) {
            rename(controller, Player.OS, terminal);
        }
    }

    private void rename(ProfileController controller, Player token, Terminal terminal) {
        String name = terminal.readString("  Nuevo nombre: ");
        controller.setName(token, name);
    }
}
