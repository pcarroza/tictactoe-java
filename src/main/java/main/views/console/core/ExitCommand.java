package main.views.console.core;

class ExitCommand extends Command {

    private final MenuView menuView;

    ExitCommand(MenuView menuView) {
        super("Salir");
        this.menuView = menuView;
    }

    @Override
    public void execute() {
        menuView.close();
    }
}
