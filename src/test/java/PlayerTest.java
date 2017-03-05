import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class PlayerTest {

    private BufferedReader in;
    private Player player;
    private Board board;

    @Before
    public void setUp() {
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        player = new Player(in, "X", board);
    }

    @Test
    public void shouldTellBoardToPlaceMarkOnTopLeftCorner() throws IOException {
        when(in.readLine()).thenReturn("1");
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