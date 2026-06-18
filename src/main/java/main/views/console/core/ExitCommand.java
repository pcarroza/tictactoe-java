package main.views.console.core;

class ExitCommand extends Command {

    private final Menu menu;

    ExitCommand(Menu menu) {
        super("Salir");
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.close();
    }
}
