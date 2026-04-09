package src.rocks.ditto.leetcode.hard;

/**
 * 1444. 切披萨的方案数
 * https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/description/
 */
public class Ways {

    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int mod = 1000_000_007;

        int[][] apples = new int[m+1][n+1];
        int[][][] dp = new int[k+1][m+1][n+1];

        //pre-process
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                // apple 数据代表 (i,j) 到 （m,n) 的苹果数
                apples[i][j] = apples[i][j+1] + apples[i+1][j] - apples[i+1][j+1] + (pizza[i].charAt(j) == 'A' ? 1:0);
                // dp数据代表 (i,j) 到 (m,n)分成1块披萨符合的方案数
                dp[1][i][j] = apples[i][j] > 0 ? 1:0;
            }
        }

        for (int ki = 2; ki <= k; ki++) {
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){

                    // 水平切
                    for (int ii = i+1; ii < m ; ii++){
                        // 判断是否符合，如果（i 到 ii 行）都没有苹果，那就不能切，因为切出来的地方没有苹果
                        if (apples[i][j] > apples[ii][j]){
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][ii][j] % mod);
                        }
                    }

                    // 垂直切
                    for (int jj = j+1; jj < n; jj++){
                        // 判断是否符合，如果（j 到 jj 行）都没有苹果，那就不能切，因为切出来的地方没有苹果
                        if (apples[i][j] > apples[i][jj]){
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][jj] % mod);
                        }
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}
