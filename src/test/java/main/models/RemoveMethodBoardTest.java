package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class RemoveMethodBoardTest {

    private Board board;

    private final Coordinate coordinate;

    public RemoveMethodBoardTest(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Parameters
    public static Collection<Coordinate[]> parameters() {
        return Arrays.asList(new Coordinate[][]{
                {new Coordinate(1, 1)},
                {new Coordinate(1, 2)},
                {new Coordinate(1, 3)},
                {new Coordinate(2, 1)},
                {new Coordinate(2, 2)},
                {new Coordinate(2, 3)},
                {new Coordinate(3, 1)},
                {new Coordinate(3, 2)},
                {new Coordinate(3, 3)}
        });
    }

    @Before
    public void setUp() {
        board = new BoardBuilder().build().getBoard();
    }

    @Test
    public void givenBoard_whenAnPlayerOS_PutAndRemoveAnCoordinateValid_thenIsEmptyHasToTrue() {
        board.put(coordinate);
        board.remove(coordinate);
        assertThat(board.isEmpty(coordinate), is(true));
    }

    @Test
    public void givenBoard_whenAnPlayerXS_PutAndRemoveAnCoordinateValid_thenIsEmptyHasToTrue() {
        board.next();
        board.put(coordinate);
        board.remove(coordinate);
        assertThat(board.isEmpty(coordinate), is(true));
    }
}
