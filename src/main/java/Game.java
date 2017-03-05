import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Game {
    private PrintStream out;
    private Player player1;
    private Player player2;
    private Board board;

    public Game(PrintStream out, Board board, Player player1, Player player2) {
        this.out = out;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        board.drawBoard();

        player1.makeMove();
        player2.makeMove();
    }

}
