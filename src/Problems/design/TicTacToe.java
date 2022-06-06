package Problems.design;

public class TicTacToe {
    private final int[][] board;
    private final int n;
    private final int[] rowSum, colSum;
    private int diagSum, antiDiagSum;
    private int winner;

    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
        this.rowSum = new int[n];
        this.colSum = new int[n];
        this.winner = 0;
    }

    /*
     * Makes a move on the board and returns the winner if the move is a winning
     * move.
     * 
     * @param player is either 0 or 1
     * 
     * @param row is the move's row index
     * 
     * @param col is the move's column index
     * 
     * @return winner 1 if first player, 2 if second player, 0 if no winner
     * 
     * @throws IllegalArgumentException if the move is invalid
     */

    public int move(int row, int col, int player) {
        if (player != 1 && player != 2) {
            throw new IllegalArgumentException("Invalid player");
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
            throw new IllegalArgumentException("Invalid move");
        }
        if (board[row][col] != 0) {
            throw new IllegalArgumentException("Cell is already occupied");
        }
        if (getWinner() != 0) {
            throw new IllegalArgumentException("Game is already over");
        }

        int currentPlayer = player == 1 ? -1 : 1;

        board[row][col] = currentPlayer;
        rowSum[row] += currentPlayer;
        colSum[col] += currentPlayer;
        if (row == col) {
            diagSum += currentPlayer;
        }
        if (row + col == n - 1) {
            antiDiagSum += currentPlayer;
        }
        if (Math.abs(rowSum[row]) == n || Math.abs(colSum[col]) == n || Math.abs(diagSum) == n
                || Math.abs(antiDiagSum) == n) {
            winner = player;
        }

        return getWinner();
    }

    /*
     * Returns the winner of the game.
     * 
     * @return winner +1 if first player, -1 if second player, 0 if no winner
     */
    public int getWinner() {
        return this.winner;
    }
}
