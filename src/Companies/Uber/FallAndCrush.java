package Companies.Uber;

import java.util.ArrayList;
import java.util.List;

public class FallAndCrush {
    private final char BOX = '#';
    private final char OBSTACLE = '*';
    private final char EMPTY = '.';

    public void fallAndCrush(char[][] board) {
        applyGravity(board);
    }

    //not working correctly 
    protected void applyGravity2(char[][] board) {
        int falls = 1;
        while (falls != 0) {
            falls = 0;
            List<int[]> explodeCells = new ArrayList<>();

            for (int i = board.length - 2; i >= 0; i--) {
                for (int j = 0; j < board.length - 1; j++) {

                    if (board[j][i] == BOX && isValidCell(board, j + 1, i)) {
                        if(board[j+1][i] == EMPTY) {
                            falls++;
                            board[j+1][i] = BOX;
                            board[j][i] = EMPTY;
                            continue;
                        }
    
                        // cell below is an obstacle
                        if (board[j+1][i] == OBSTACLE) {
                            falls++;
                            board[j][i] = EMPTY;
                            explodeCells.add(new int[]{i+1, j});
                            continue;
                        }
                    }
                }

                for(int[] cell : explodeCells){
                    explode(cell[0], cell[1], board);
                }
            }
        }
    }

    protected void applyGravity(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length - 1; row++) {
                if (board[row][col] == BOX) {
                    board[row][col] = EMPTY;

                    if (board[row + 1][col] == BOX) {
                        board[row + 1][col] = EMPTY;
                    }

                    else if (board[row + 1][col] == OBSTACLE) {
                        explode(row, col, board);
                    }

                    else {
                        board[row + 1][col] = BOX;
                    }
                }
            }
        }
    }

    protected void explode(int row, int col, char[][] board) {
        int dx[] = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
        int dy[] = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };

        for (int i = 0; i < dx.length; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            if (isValidCell(board, x, y) && board[x][y] == BOX) {
                board[x][y] = EMPTY;
            }
        }
    }

    boolean isValidCell(char[][] board, int row, int col) {
        boolean rowInBounds = 0 <= row && row <= board.length - 1;
        boolean colInBounds = 0 <= col && col <= board[0].length - 1;
        return rowInBounds && colInBounds;
    }

    public void run() {
        char[][] board = {
                { '#', '.', '#', '#', '*' },
                { '#', '.', '.', '#', '#' },
                { '.', '#', '.', '#', '.' },
                { '.', '.', '#', '.', '#' },
                { '#', '*', '.', '.', '.' },
                { '.', '.', '*', '#', '.' }
        };

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

        System.out.println();

        fallAndCrush(board);

        System.out.println("\n");

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
