import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class Player {

    private BufferedReader in;
    private String symbol;
    private Board board;

    public Player(BufferedReader in, String symbol, Board board) {
        this.in = in;
        this.symbol = symbol;
        this.board = board;
    }

    public void makeMove(){
        int nextMove = getNextMove();
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
