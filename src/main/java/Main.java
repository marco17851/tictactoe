import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Main {
    public static void main (String [] args){
        PrintStream out = System.out;
        Game game = new Game(out);
        game.start();
    }
}
