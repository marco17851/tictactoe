import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Game {
    private PrintStream out;
    private BufferedReader in;
    private Board board;

    public Game(PrintStream out, BufferedReader in, Board board) {
        this.out = out;
        this.in = in;
        this.board = board;
    }

    public void start() {
        board.drawBoard();
        out.println("Please enter a number between 1 and 9.");
        int nextMove = getNextMove();
        board.placeMark("X", nextMove);
    }

    private int getNextMove() {
        int nextMove = -1;
        try {
            nextMove = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nextMove;
    }

}
