import org.junit.Before;
import org.junit.Test;

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
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(out, board, player1, player2);
    }

    @Test
    public void shouldTellBoardToPrintItselfOnStart() throws IOException {
        game.start();
        verify(board).drawBoard();
    }

    @Test
    public void shouldTellPlayer1ToMakeAMove() {
        game.start();
        verify(player1).makeMove();
    }

    @Test
    public void shouldTellPlayer2ToMakeAMove(){
        game.start();

        verify(player2).makeMove();
    }

}