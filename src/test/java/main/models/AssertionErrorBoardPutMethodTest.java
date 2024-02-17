package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

public class AssertionErrorBoardPutMethodTest {

    @Test(expected = AssertionError.class)
    public void givenBoard_whenTheCoordinateIsNull_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.put(null);
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenPutColorOnTheSameCoordinate_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        board.put(new Coordinate(1, 1));
        board.put(new Coordinate(1, 1));
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenTheRowIsLessThanSpecified_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        final int ROW = 0;
        board.put(new Coordinate(ROW, 1));
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenTheColumnIsGreaterThanSpecified_thenAssertionError() {
        Board board = new BoardBuilder().build().getBoard();
        final int COLUMN = 4;
        board.put(new Coordinate(1, COLUMN));
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenOneMoreTokenIsPutOnTheOSBoard_thenAssertionError() {
        Board boardPlayerOS = createSceneryBoardPlayerOS();
        boardPlayerOS.put(new Coordinate(2, 1));
    }

    private Board createSceneryBoardPlayerOS() {
        return new BoardBuilder()
                .build()
                .put(new Coordinate(1, 1))
                .put(new Coordinate(1, 2))
                .put(new Coordinate(1, 3))
                .getBoard();
    }

    @Test(expected = AssertionError.class)
    public void givenBoard_whenOneMoreTokenIsPutOnTheXSBoard_thenAssertionError() {
        Board boardPlayerXS = createSceneryBoardPlayerXS();
        boardPlayerXS.put(new Coordinate(2, 1));
    }

    private Board createSceneryBoardPlayerXS() {
        return new BoardBuilder()
                .build()
                .switchTurn()
                .put(new Coordinate(1, 1))
                .put(new Coordinate(1, 2))
                .put(new Coordinate(1, 3))
                .getBoard();
    }
}