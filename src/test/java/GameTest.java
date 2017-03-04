import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class GameTest {

    @Test
    public void shouldDrawBoardOnStart() {
        PrintStream out = mock(PrintStream.class);
        Game game = new Game(out);
        game.start();

        verify(out).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }
}