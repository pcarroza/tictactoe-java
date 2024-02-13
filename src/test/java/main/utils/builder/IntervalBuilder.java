package main.utils.builder;

import main.utils.ClosedInterval;

public abstract class IntervalBuilder {

    protected int min;

    protected int max;

    protected IntervalBuilder(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public IntervalBuilder setMin(int min) {
        this.min = min;
        return this;
    }

    public IntervalBuilder setMax(int max) {
        this.max = max;
        return this;
    }

    public abstract ClosedInterval<Integer> getClosedInterval();

    public abstract IntervalBuilder build();
}
