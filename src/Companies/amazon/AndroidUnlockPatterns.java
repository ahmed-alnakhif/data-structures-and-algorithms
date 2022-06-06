package Companies.amazon;

/**
 * Given two integers m and n, return the number of unique and valid unlock
 * patterns of the Android grid lock screen that consist of at least m keys and
 * at most n keys.
 * 
 * Two unlock patterns are considered unique if there is a dot in one sequence
 * that is not in the other, or the order of the dots is different.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: m = 1, n = 1
 * Output: 9
 * Example 2:
 * 
 * Input: m = 1, n = 2
 * Output: 65
 */

public class AndroidUnlockPatterns {
    private int[][] skip;
    private boolean[] visited;

    public int numberOfPatterns(int m, int n) {
        visited = new boolean[10];
        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        int patternsCount = 0;
        for (int i = m; i <= n; i++) {
            patternsCount += dfs(1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
            patternsCount += dfs(2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
            patternsCount += dfs(5, i - 1); // 5
        }

        return patternsCount;
    }

    private int dfs(int currNum, int remain) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;

        visited[currNum] = true;
        
        int count = 0;
        for (int num = 1; num <= 9; num++) {
            int skipNum = skip[currNum][num];
            // if num is not visited AND
            // skip == 0; meaning that the two numbers are adjacent OR have visited skip number
            if (!visited[num] && (skipNum == 0 || visited[skipNum])) {
                count += dfs(num, remain - 1);
            }
        }
        
        visited[currNum] = false; // backtracking

        return count;
    }
}
