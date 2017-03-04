import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class GameTest {

    private PrintStream out;
    private Game game;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        game = new Game(out);
    }

    @Test
    public void shouldDrawBoardOnStart() {
        game.start();

        verify(out).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldPromptPlayerToEnterANumber() {
        game.start();

        verify(out).println(contains("enter a number"));
    }

    @Test
    public void shouldRedrawTheBoardWithPlayerSymbolXAtTopLeftCorner() {
        game.start();
        verify(out).println("X|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldRedrawTheBoardWithPlayerSymbolXAtTopRightCorner() {
        game.start();
        verify(out).println("1|2|X\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }
}