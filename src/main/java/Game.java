import java.io.PrintStream;

/**
 * Created by MarcoBarragan on 3/4/17.
 */
public class Game {
    private PrintStream out;
    private Player player1;
    private Player player2;
    private Board board;
    private int curTurn;
    private boolean gameWon;
    private String winningPlayer;

    public Game(PrintStream out, Board board, Player player1, Player player2) {
        this.out = out;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        board.drawBoard();
        curTurn = 0;
        gameWon = false;

        while (!board.isFilled() && !gameWon){
            curTurn += 1;
            takeTurn(getNextPlayer());
        }

        if (gameWon){
            out.println("Player " + winningPlayer + " Wins!");
        } else {
            out.println("Game is a draw");
        }
    }

    private Player getNextPlayer() {
        if (curTurn % 2 == 0){
            return player2;
        }
        return player1;
    }

    private void takeTurn(Player player){
        player.makeMove();
        if (board.hasWinningRow()){
            gameWon = true;
            winningPlayer = player.getSymbol();
        }
    }

}
