package Companies.Uber;

public class FallAndCrush {
    private final char STONE = '#';
    private final char OBSTACLE = '*';
    private final char EMPTY = '.';

    public char[][] fallAndCrush(char[][] board) {
        applyGravity(board);
        return rotate(board);
    }

    protected void applyGravity(char[][] board) {
        for (char[] row : board) {
            int emptyPos = row.length - 1;

            for (int col = row.length - 1; col >= 0; col--) {
                if (row[col] == STONE) {
                    row[col] = EMPTY;
                    row[emptyPos--] = STONE;
                } else if (row[col] == OBSTACLE) {
                    emptyPos = col - 1;
                }
            }
        }
    }

    protected char[][] rotate(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        char[][] newBoard = new char[colLen][rowLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                newBoard[col][rowLen - 1 - row] = board[row][col];
            }
        }

        return newBoard;
    }

    public void run() {
        char[][] board = {
                { '#', '#', '*', '.', '*', '.' },
                { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' },
        };

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

        System.out.println();

        char[][] newBoard = fallAndCrush(board);

        System.out.println("\n");

        for (int row = 0; row < newBoard.length; row++) {
            for (int col = 0; col < newBoard[0].length; col++) {
                System.out.print(newBoard[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
