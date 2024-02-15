package main.utils;

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
        int value;
        boolean ok;
        do {
            value = Terminal.getInstance().readInt(title + " " + limitsView + ": ");
            ok = limits.isIncluded(value);
            if (!ok) {
                limitsView.writeln();
            }
        } while (!ok);
        return value;
    }

    public int read(String title, int max) {
        return read(title, 1, max);
    }
}
