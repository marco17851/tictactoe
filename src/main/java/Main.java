import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Main {
    public static void main (String [] args){
        PrintStream out = System.out;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String [] cells = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board(out, cells);
        Game game = new Game(out, in, board);
        game.start();
    }
}
