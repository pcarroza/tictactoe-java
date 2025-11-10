package main.utils;

public record ClosedIntervalView(String title, ClosedInterval<Integer> closedInterval) {

    public ClosedIntervalView {
        assert title != null;
        assert closedInterval != null;
    }

    public void writeln() {
        Terminal.getInstance().writeln(title + " " + this);
    }

    @Override
    public String toString() {
        return closedInterval.toString();
    }
}
