package main.views.console.core.commands;

import main.views.console.core.Feature;

class ExitCommand extends Command {

    private boolean closed;

    protected ExitCommand() {
        super("Salir");
        this.reset();
    }

    @Override
    public void execute(Feature feature) {
        closed = true;
    }

    public boolean closed() {
        return closed;
    }

    public void reset() {
        closed = false;
    }
}
