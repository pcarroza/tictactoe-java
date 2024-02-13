package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

public class AssertionErrorBoardRemoveMethodTest {

    @Test(expected = AssertionError.class)
    public void givenBoard_whenTheCoordinateIsNullInTheMethodRemove_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.remove(null);
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenYouWantToRemoveColorThatDoesNotExist_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.remove(new Coordinate(1, 1));
    }

    @Test
    public void givenBoard_whenToRemoveAnExisting_Color_then() {
        Board board = new BoardBuilder().build().getBoard();
        board.put(new Coordinate(1, 2));
        board.remove(new Coordinate(1, 2));
    }
}
