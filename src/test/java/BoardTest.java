import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

}