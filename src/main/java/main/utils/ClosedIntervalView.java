package main.utils;

public class ClosedIntervalView {

    private final String title;

    private final ClosedInterval<Integer> closedInterval;

    public ClosedIntervalView(String title, ClosedInterval<Integer> closedInterval) {
        assert title != null;
        assert closedInterval != null;
        this.title = title;
        this.closedInterval = closedInterval;
    }

    public void writeln() {
        Terminal.getInstance().writeln(title + " " + this);
    }

    @Override
    public String toString() {
        return closedInterval.toString();
    }
}
