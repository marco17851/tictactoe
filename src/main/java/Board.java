import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class Board {

    private PrintStream out;
    private String [] cells;

    public Board(PrintStream out, String[] cells) {
        this.out = out;
        this.cells = cells;
    }

    public void drawBoard() {
        String printedBoard = cells[0] + "|" + cells[1] + "|" + cells[2] +
                "\n-----\n" +
                cells[3] + "|" + cells[4] + "|" + cells[5] +
                "\n-----\n" +
                cells[6] + "|" + cells[7] + "|" + cells[8];

        out.println(printedBoard);
    }

    public void placeMark(String symbol, int location) {
        if (cells[location-1] == "X" || cells[location-1] == "X"){
            out.println("Location already taken. Please try again.");
        } else {
            cells[location - 1] = symbol;
            drawBoard();
        }
    }
}
