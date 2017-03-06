import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class Board {

    private PrintStream out;
    private String [] cells;
    private boolean [] marked_cells;
    private int num_cells_left;

    public Board(PrintStream out, String[] cells) {
        this.out = out;
        this.cells = cells;
        num_cells_left = cells.length;
    }

    public void drawBoard() {
        String printedBoard = cells[0] + "|" + cells[1] + "|" + cells[2] +
                "\n-----\n" +
                cells[3] + "|" + cells[4] + "|" + cells[5] +
                "\n-----\n" +
                cells[6] + "|" + cells[7] + "|" + cells[8];

        out.println(printedBoard);
    }

    public boolean isLocationTaken(int location){
        if (cells[location-1].equals("X") || cells[location-1].equals("O")){
            return true;
        }
        return false;
    }

    public void placeMark(String symbol, int location) {
        cells[location - 1] = symbol;
        num_cells_left -= 1;
        drawBoard();
    }

    public boolean isFilled(){
        if (num_cells_left > 0){
            return false;
        }
        return true;
    }
}
