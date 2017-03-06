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
        when(board.isFilled()).thenReturn(true);
    }

    @Test
    public void shouldTellBoardToPrintItselfOnStart() throws IOException {
        game.start();
        verify(board).drawBoard();
    }

    @Test
    public void shouldTellPlayer1ToMakeAMove() {
        when(board.isFilled()).thenReturn(false, true);
        game.start();
        verify(player1).makeMove();
    }

    @Test
    public void shouldTellPlayer2ToMakeAMove(){
        when(board.isFilled()).thenReturn(false, false, true);
        game.start();
        verify(player2).makeMove();
    }

    @Test
    public void shouldAskBoardIfItIsFull() {
        game.start();

        verify(board).isFilled();
    }

    @Test
    public void shouldAnnounceThatGameIsADrawWhenDone() {
        when(board.isFilled()).thenReturn(true);
        game.start();
        verify(out).println(contains("draw"));
    }

}