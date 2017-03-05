import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class PlayerTest {

    private BufferedReader in;
    private PrintStream out;
    private Player player;
    private Board board;

    @Before
    public void setUp() throws IOException {
        in = mock(BufferedReader.class);
        out = mock(PrintStream.class);
        board = mock(Board.class);
        player = new Player(in, out,"X", board);
        when(in.readLine()).thenReturn("1");
    }

    @Test
    public void shouldPromptPlayerToInputTheirChosenLocation(){
        player.makeMove();

        verify(out).println(contains("enter a number"));
    }

    @Test
    public void shouldDisplayThatLocationAlreadyTaken() {
        when(board.isLocationTaken(anyInt())).thenReturn(true);
        player.makeMove();

        verify(out).println(contains("taken"));
    }

    @Test
    public void shouldPlaceMarkIfChosenPlayerLocationNotAlreadyTaken() {
        when(board.isLocationTaken(anyInt())).thenReturn(false);
        player.makeMove();

        verify(board).placeMark(anyString(), anyInt());
    }

    @Test
    public void shouldTellBoardToPlaceMarkOnTopLeftCorner(){
        player.makeMove();

        verify(board).placeMark("X", 1);
    }

    @Test
    public void shouldTellBoardToPlaceMarkOnBottomRightCorner() throws IOException {
        when(in.readLine()).thenReturn("9");
        player.makeMove();

        verify(board).placeMark("X", 9);
    }
}