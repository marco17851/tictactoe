import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Game {
    private PrintStream out;

    public Game(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
        out.println("Please enter a number between 1 and 9.");
        out.println("X|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
        out.println("1|2|X\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }
}
