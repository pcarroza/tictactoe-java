package main.common.utils;

public class LimitedIntDialog {

    private static LimitedIntDialog limitedIntDialog;

    public static LimitedIntDialog instance() {
        if (limitedIntDialog == null) {
            limitedIntDialog = new LimitedIntDialog();
        }
        return limitedIntDialog;
    }

    private LimitedIntDialog() {}

    public int read(String title, int min, int max) {
        assert title != null;
        ClosedInterval<Integer> limits = new ClosedInterval<>(min, max);
        ClosedIntervalView limitsView = new ClosedIntervalView("El valor debe estar entre ", limits);
        int value = Terminal.getInstance().readInt(title + " " + limitsView + ": ");
        boolean ok = limits.isIncluded(value);
        if (!ok) {
            limitsView.writeln();
            value = read(title, min, max);
        }
        return value;
    }

    public int read(String title, int max) {
        return read(title, 1, max);
    }
}
