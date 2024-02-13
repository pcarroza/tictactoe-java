package main.utils;

import main.models.Coordinate;
import main.utils.builder.ClosedIntervalBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClosedIntervalTest {

    private final int MIN = 1;
    private final int MAX = Coordinate.DIMENSION;
    private ClosedInterval<Integer> closedInterval;

    @Before
    public void setUp() {
        this.closedInterval = new ClosedIntervalBuilder(MIN, MAX)
                .build()
                .getClosedInterval();
    }

    @Test(expected = AssertionError.class)
    public void givenClosedInterval_whenTheMinIsLessThanTheMax_thenAssertionError() {
        new ClosedIntervalBuilder()
                .setMin(MAX)
                .setMax(MIN)
                .build()
                .getClosedInterval();
    }

    @Test
    public void givenClosedInterval_whenValueEqualsMinimum_thenIsTrue() {
        assertThat(this.closedInterval.isIncluded(MIN), is(true));
    }

    @Test
    public void givenClosedInterval_whenValueEqualsMaximum_thenIsTrue() {
        assertThat(this.closedInterval.isIncluded(MAX), is(true));
    }

    @Test
    public void givenClosedInterval_whenValueIsLessThanMinimum_thenIsFalse() {
        assertThat(this.closedInterval.isIncluded(MIN - 1), is(false));
    }

    @Test
    public void givenClosedInterval_whenValueIsGreaterMinimum_thenIsTrue() {
        assertThat(this.closedInterval.isIncluded(MIN + 1), is(true));
    }

    @Test
    public void givenClosedInterval_whenValueIsLessThanMaximum_thenIsTrue() {
        assertThat(this.closedInterval.isIncluded(MAX - 1), is(true));
    }

    @Test
    public void givenClosedInterval_whenValueIsGreaterThanMaximum_thenIsFalse() {
        assertThat(this.closedInterval.isIncluded(MAX + 1), is(false));
    }
}

