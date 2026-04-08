package src.rocks.ditto.leetcode.hard;

/**
 * 741. cherryPickup
 * https://leetcode.cn/problems/cherry-pickup/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class CherryPickup {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // a minium score
        int infinite = Integer.MIN_VALUE;
        int[][][] dp  = new int[2*n+1][n+1][n+1];
        // initialize the matrix
        for (int i = 0; i <= 2*n; i++) {
            for (int x1 = 0; x1 <= n; x1++) {
                for (int x2 = 0; x2 <= n; x2++) {
                    dp[i][x1][x2] = infinite;
                }
            }
        }
        // start point
        dp[2][1][1] = grid[0][0];

        for (int k = 3; k <= 2 * n; k++) {
            for (int x1 = 1; x1 <= n; x1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    // check y
                    int y1 = k - x1;
                    int y2 = k - x2;
                    // if over
                    if (y1 <= 0 ||  y1 > n || y2 <= 0 ||  y2 > n) continue;
                    // check the point if has -1
                    int point1 = grid[x1-1][y1-1];
                    int point2 = grid[x2-1][y2-1];
                    if (point1 == -1 || point2 == -1) continue;

                    // from (x1-1, k-x1) (x2, k-x2-1)
                    int a = dp[k-1][x1-1][x2];
                    // from (x1-1, k - x1) (x2 - 1, k-x2)
                    int b = dp[k-1][x1-1][x2-1];
                    // from (x1, k-x1-1)  (x2-1, k-x2)
                    int c = dp[k-1][x1][x2-1];
                    // from (x1, k-x1-1), (x2, k-x2-1)
                    int d = dp[k-1][x1][x2];
                    int del = Math.max(Math.max(a, b), Math.max(c, d)) + point1 ;
                    // not same one
                    if (x1 != x2) del += point2;
                    dp[k][x1][x2] = del;
                }
            }
        }
        return Math.max(dp[2 * n][n][n], 0);
    }
}
