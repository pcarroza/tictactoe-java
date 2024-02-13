package main.utils;

public class ClosedIntervalView {

    private final String title;

    private final ClosedInterval<Integer> interval;

    public ClosedIntervalView(String title, ClosedInterval<Integer> closedInterval) {
        assert title != null;
        assert closedInterval != null;
        this.title = title;
        this.interval = closedInterval;
    }

    public void writeln() {
        Terminal.getInstance().writeln(this.title + " " + this);
    }

    @Override
    public String toString() {
        return interval.toString();
    }
}
