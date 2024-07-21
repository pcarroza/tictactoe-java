package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NoExistTicTacToeBoardTest {


    @Test()
    public void givenBoardOfPlayerOS_whenBoardNotInHorizontal_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - O")
                .put("O O -")
                .put("- - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsNotInverse_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - O")
                .put("- O -")
                .put("- O -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsNotInDiagonal_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("O - -")
                .put("- O -")
                .put("- O -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsNotVertical_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- O -")
                .put("- O -")
                .put("- - O")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }


    @Test()
    public void givenBoardOfPlayerXS_whenBoardIsNotVertical_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - X")
                .put("- X -")
                .put("- X -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardNotInDiagonal_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("X - -")
                .put("- X -")
                .put("- X -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardNotInHorizontal_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - X")
                .put("X X -")
                .put("- - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardNotInVertical_thenNotExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- X -")
                .put("- X -")
                .put("X - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }
}
