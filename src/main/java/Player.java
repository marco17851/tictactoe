import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class Player {

    private BufferedReader in;
    private PrintStream out;
    private String symbol;
    private Board board;

    public Player(BufferedReader in, PrintStream out, String symbol, Board board) {
        this.in = in;
        this.out = out;
        this.symbol = symbol;
        this.board = board;
    }

    public void makeMove(){
        out.println("Player " + symbol + ": please enter a number between 1 and 9.");
        int nextMove = getNextMove();

        while(board.isLocationTaken(nextMove)){
            out.println("Location already taken");
            nextMove = getNextMove();
        }

        board.placeMark(symbol, nextMove);
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
