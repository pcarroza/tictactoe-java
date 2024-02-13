package main.utils;

public class ClosedInterval<T extends Number & Comparable<T>> {

    private final T min;

    private final T max;

    public ClosedInterval(T min, T max) {
        assert min.compareTo(max) < 0;
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return this.min;
    }

    public T getMax() {
        return this.max;
    }

    public boolean isIncluded(T value) {
        return this.min.compareTo(value) <= 0 && value.compareTo(this.max) <= 0;
    }

    @Override
    public String toString() {
        return "[" + getMin() + ", " + getMax() + "]";
    }
}
