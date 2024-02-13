package main.utils;

import java.util.function.Predicate;

public class YesNoDialog {

    private static YesNoDialog yesNoDialog;

    private static final Predicate<Character> CORRECT_ANSWERS = c -> c == 's'  || c == 'S' || c == 'n' || c == 'N' ;

    public static YesNoDialog instance() {
        if (yesNoDialog == null) {
            yesNoDialog = new YesNoDialog();
        }
        return yesNoDialog;
    }

    public boolean read(String title) {
        assert title != null;
        char answer;
        do {
            answer = Terminal.getInstance().readChar(title + " (s/n):");
            if (!CORRECT_ANSWERS.test(answer)) {
                Terminal.getInstance().writeln("El valor de ser 's' o 'n'");
            }
        } while (!CORRECT_ANSWERS.test(answer));
        return answer == 's' || answer == 'S';
    }
}
