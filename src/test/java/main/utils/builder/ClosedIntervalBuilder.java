package main.utils.builder;

import main.utils.ClosedInterval;

public class ClosedIntervalBuilder extends IntervalBuilder {

    private ClosedInterval<Integer> closedInterval;

    public ClosedIntervalBuilder(int min, int max) {
        super(min, max);
    }

    public ClosedIntervalBuilder() {
        this(0, 0);
    }

    @Override
    public ClosedInterval<Integer> getClosedInterval() {
        return closedInterval;
    }

    @Override
    public ClosedIntervalBuilder build() {
        closedInterval = new ClosedInterval<>(min, max);
        return this;
    }
}
