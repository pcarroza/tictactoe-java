package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompleteBoardTest {

    @Test
    public void givenBoard_WhenSixTokenArePutOnBoard_ThenIsCompleteIsTrue() {
        Board boardComplete = new BoardBuilder()
                .build()
                .put("O O O")
                .put("X X X")
                .put("- - -")
                .getBoard();
        assertThat(boardComplete.isComplete(), is(equalTo(true)));
    }

    @Test
    public void givenBoard_WhenTokensLessThanSixArePutOnBoard_ThenIsCompleteIsFalse() {
        Board boardNotComplete = new BoardBuilder()
                .build()
                .put("O O O")
                .put("X X -")
                .put("- - -")
                .getBoard();
        assertThat(boardNotComplete.isComplete(), is(false));
    }
}
