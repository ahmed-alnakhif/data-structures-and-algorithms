package Problems.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 * Example 2:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 */

public class WordSearch {

    int[] rowDir = { 0, 1, 0, -1 };
    int[] colDir = { 1, 0, -1, 0 };

    Set<String> charSet = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
                charSet.clear();
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        String key = row + "," + col;

        // base cases:
        if (index >= word.length())
            return true;
        if (!isInbound(board, row, col))
            return false;
        if (word.charAt(index) != board[row][col])
            return false;
        if (charSet.contains(key))
            return false;

        charSet.add(key);

        boolean result = false;
        for (int i = 0; i < 4; i++) {
            result = dfs(board, word, rowDir[i] + row, colDir[i] + col, index + 1);
            if (result) {
                return true;
            }
        }

        charSet.remove(key);

        return false;
    }

    private boolean isInbound(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public static void main(String[] args) {

    }
}
