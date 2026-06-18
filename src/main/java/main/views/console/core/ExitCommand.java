package main.views.console.core;

class ExitCommand extends Command {

    private final Menu menuView;

    ExitCommand(Menu menuView) {
        super("Salir");
        this.menuView = menuView;
    }

    @Override
    public void execute() {
        menuView.close();
    }
}
