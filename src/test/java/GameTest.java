import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class GameTest {

    private PrintStream out;
    private BufferedReader in;
    private Game game;
    private Board board;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        game = new Game(out, in, board);
    }

    @Test
    public void shouldTellBoardToPrintItselfOnStart() throws IOException {
        when(in.readLine()).thenReturn("1");
        game.start();
        verify(board).drawBoard();
    }

    @Test
    public void shouldPromptPlayerToEnterANumber() throws IOException {
        when(in.readLine()).thenReturn("1");
        game.start();

        verify(out).println(contains("enter a number"));
    }

    @Test
    public void shouldTellBoardToMarkLocationOnPlayersChosenLocationTopLeftCorner() throws IOException {
        when(in.readLine()).thenReturn("1");
        game.start();

        verify(board).placeMark("X", 1);
    }

}