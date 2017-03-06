import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/5/17.
 */
public class Board {

    private PrintStream out;
    private String [] cells;
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

    public boolean hasWinningRow() {
        boolean hasWon = false;

        if (cells[0] == cells[1] && cells[0] == cells[2]){
            hasWon = true;
        } else if (cells[3] == cells[4] && cells[3] == cells[5]){
            hasWon = true;
        } else if (cells[6] == cells[7] && cells[6] == cells[8]){
            hasWon = true;
        }

        return hasWon;
    }

    public boolean hasWinningColumn() {
        boolean hasWon = false;

        if (cells[0] == cells[3] && cells[0] == cells[6]){
            hasWon = true;
        } else if (cells[1] == cells[4] && cells[1] == cells[7]){
            hasWon = true;
        } else if (cells[2] == cells[5] && cells[2] == cells[8]){
            hasWon = true;
        }

        return hasWon;
    }
}
