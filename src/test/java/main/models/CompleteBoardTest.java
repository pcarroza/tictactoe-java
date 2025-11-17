package main.models;

import main.models.builders.BoardBuilder;
import main.models.modules.game.Board;
import main.models.modules.game.Coordinate;
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
                .put(new Coordinate(1, 1))
                .put(new Coordinate(1, 2))
                .put(new Coordinate(1, 3))
                .switchTurn()
                .put(new Coordinate(2, 1))
                .put(new Coordinate(2, 2))
                .put(new Coordinate(2, 3))
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
                .put(new Coordinate(1, 1))
                .put(new Coordinate(1, 2))
                .put(new Coordinate(1, 3))
                .switchTurn()
                .put(new Coordinate(2, 1))
                .put(new Coordinate(2, 2))
                .getBoard();
    }
}
