package main.models;

import main.models.builders.BoardBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NoExistTicTacToeBoardTest {

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsInDiagonal_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- O -")
                .put("- O -")
                .put("- - O")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsInverse_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- 0 -")
                .put("- O -")
                .put("O - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardInHorizontalTop_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("O O -")
                .put("- - O")
                .put("- - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardInHorizontal_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - -")
                .put("O O -")
                .put("- - O")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }


    @Test()
    public void givenBoardOfPlayerOS_whenBoardInHorizontalBottom_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - -")
                .put("- - O")
                .put("O O -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsVerticalLeft_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- O -")
                .put("O - -")
                .put("O - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsVertical_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - O")
                .put("- O -")
                .put("- O -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerOS_whenBoardIsVerticalRight_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- O -")
                .put("- - O")
                .put("- - O")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardIsInverse_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - -")
                .put("- X X")
                .put("X - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInDiagonal_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("X - -")
                .put("- X X")
                .put("- - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInHorizontalTop_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("X X -")
                .put("- - X")
                .put("- - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInHorizontal_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - X")
                .put("X X -")
                .put("- - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInHorizontalBottom_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - -")
                .put("- - X")
                .put("X X -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInVerticalLeft_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- X -")
                .put("X - -")
                .put("X - -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInVertical_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- - X")
                .put("- X -")
                .put("- X -")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }

    @Test()
    public void givenBoardOfPlayerXS_whenBoardInVerticalRight_thenExistTicTacToe() {
        Board board = new BoardBuilder()
                .build()
                .put("- X -")
                .put("- - X")
                .put("- - X")
                .getBoard();
        assertThat(board.existTicTacToe(), is(false));
    }
}
