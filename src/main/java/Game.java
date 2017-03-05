import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Game {
    private PrintStream out;
    private BufferedReader in;
    private Player player1;
    private Player player2;
    private Board board;

    public Game(PrintStream out, BufferedReader in, Board board, Player player1, Player player2) {
        this.out = out;
        this.in = in;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        board.drawBoard();

        out.println("Please enter a number between 1 and 9.");
        player1.makeMove();

        out.println("Please enter a number between 1 and 9.");
        player2.makeMove();
    }



}
