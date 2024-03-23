package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

public class AssertionErrorBoardRemoveMethodTest {

    private static final int SOME_ROW = 1;

    private static final int SOME_COLUMN = Coordinate.DIMENSION;

    @Test(expected = AssertionError.class)
    public void givenBoard_whenTheCoordinateIsNullInTheMethodRemove_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.remove(null);
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenYouWantToRemoveColorThatDoesNotExist_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.remove(new Coordinate(SOME_ROW, SOME_COLUMN));
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenToRemoveAnExistingColor_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.switchTurn();
        board.put(new Coordinate(SOME_ROW, SOME_COLUMN));
        board.remove(new Coordinate(SOME_ROW, SOME_COLUMN));
        board.remove(new Coordinate(SOME_ROW, SOME_COLUMN));
    }
}

