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
        cells[location-1] = symbol;
        drawBoard();
    }
}
