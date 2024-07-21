package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompleteBoardTest {

    @Test
    public void givenBoard_WhenSixTokenArePutOnBoard_ThenIsCompleteIsTrue() {
        Board boardComplete = createSceneryBoardComplete();
        assertThat(boardComplete.isComplete(), is(equalTo(true)));
    }

    public Board createSceneryBoardComplete() {
        return new BoardBuilder()
                .build()
                .put("O O O")
                .put("X X X")
                .put("- - -")
                .getBoard();
    }

    @Test
    public void givenBoard_WhenTokensLessThanSixArePutOnBoard_ThenIsCompleteIsFalse() {
        Board boardNotComplete = createSceneryBoardNotComplete();
        assertThat(boardNotComplete.isComplete(), is(false));
    }

    public Board createSceneryBoardNotComplete() {
        return new BoardBuilder()
                .build()
                .put("O O O")
                .put("X X -")
                .put("- - -")
                .getBoard();
    }
}
