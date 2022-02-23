package Companies.Uber;

public class FallAndCrush {

    public void fallAndCrush(int[][] board) {

    }

    public void run() {
        int[][] board = {
                { '#', '.', '#', '#', '*' },
                { '#', '.', '.', '#', '#' },
                { '.', '#', '.', '#', '.' },
                { '.', '.', '#', '.', '#' },
                { '#', '*', '.', '.', '.' },
                { '.', '.', '*', '#', '.' }
        };

        fallAndCrush(board);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + ",");
            }
            System.out.println();
        }
    }
}
