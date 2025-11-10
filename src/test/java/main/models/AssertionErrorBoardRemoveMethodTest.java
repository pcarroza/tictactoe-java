package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

public class AssertionErrorBoardRemoveMethodTest {

    private static final int ROW_NOT_SPECIFIED = 1;

    private static final int COLUMN_NOT_SPECIFIED = 5;

    @Test(expected = AssertionError.class)
    public void givenBoard_whenTheCoordinateIsNullInTheMethodRemove_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.remove(null);
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenYouWantToRemoveColorThatDoesNotExist_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.remove(new Coordinate(ROW_NOT_SPECIFIED, COLUMN_NOT_SPECIFIED));
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenToRemoveAnExisting_Color_then() {
        Board board = new BoardBuilder().build().getBoard();
        board.changeTurn();
        board.put(new Coordinate(ROW_NOT_SPECIFIED, COLUMN_NOT_SPECIFIED));
        board.remove(new Coordinate(ROW_NOT_SPECIFIED, COLUMN_NOT_SPECIFIED));
        board.remove(new Coordinate(ROW_NOT_SPECIFIED, COLUMN_NOT_SPECIFIED));
    }
}
