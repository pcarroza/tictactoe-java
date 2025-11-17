package main.models;

import main.models.modules.game.Board;
import main.models.builders.BoardBuilder;
import org.junit.Before;
import org.junit.Test;

public class RemoveMethodBoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new BoardBuilder().build().getBoard();
    }

    @Test
    public void given_when_then() {

    }
}
