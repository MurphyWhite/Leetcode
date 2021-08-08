package src.rocks.ditto.leetcode.easy;

/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Tribonacci {

    private static final int[] dp = new int[38];

    static {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
    }

    /**
     * dp
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n <= 2){
            return dp[n];
        }
        for (int i = 3 ; i <=n; i++){
            dp[i] = dp[i-1] + dp[i - 2] + dp[i-3];
        }
        return dp[n];
    }
}
