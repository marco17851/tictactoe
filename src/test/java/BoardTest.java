import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class BoardTest {

    private Board board;
    private PrintStream out;
    private String [] cells;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        board = new Board(out, cells);
    }

    @Test
    public void shouldDrawBoardOnStart() {
        board.drawBoard();
        verify(out).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldRedrawTheBoardWithPlayerSymbolXAtTopLeftCorner() {
        board.placeMark("X", 1);
        verify(out).println("X|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldRedrawTheBoardWithPlayerSymbolXAtTopRightCorner() {
        board.placeMark("X", 3);
        verify(out).println("1|2|X\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldCheckThatLocationIsAlreadyMarked() {
        cells[1] = "X";

        assertThat(board.isLocationTaken(2), is(true));
    }

    @Test
    public void shouldCheckThatLocationIsNotYetMarked() {
        assertThat(board.isLocationTaken(2), is(false));
    }

    @Test
    public void shouldVerifyThatBoardIsFilled() {
        board.placeMark("X", 1);
        board.placeMark("X", 2);
        board.placeMark("X", 3);
        board.placeMark("X", 4);
        board.placeMark("X", 5);
        board.placeMark("X", 6);
        board.placeMark("X", 7);
        board.placeMark("X", 8);
        board.placeMark("X", 9);

        assertThat(board.isFilled(), is(true));
    }

    @Test
    public void shouldVerifyThatBoardIsNotFilled() {
        board.placeMark("X", 1);

        assertThat(board.isFilled(), is(false));
    }

    @Test
    public void shouldVerifyThatBoardHasAWinningRow() {
        cells[3] = "X";
        cells[4] = "X";
        cells[5] = "X";

        assertThat(board.hasWinningRow(), is(true));
    }

    @Test
    public void shouldVerifyThatBoardDoesNotHaveAWinningRow() {
        assertThat(board.hasWinningRow(), is(false));
    }

    @Test
    public void shouldVerifyThatBoardHasAWinningColumn() {
        cells[1] = "X";
        cells[4] = "X";
        cells[7] = "X";

        assertThat(board.hasWinningColumn(), is(true));
    }

    @Test
    public void shouldVerifyThatBoardDoesNotHaveAWinningColumn() {
        assertThat(board.hasWinningColumn(), is(false));
    }

}