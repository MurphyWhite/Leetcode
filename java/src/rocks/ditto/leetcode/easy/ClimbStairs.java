package src.rocks.ditto.leetcode.easy;

/**
 *  70. 爬楼梯
 *  https://leetcode-cn.com/problems/climbing-stairs/
 *
 *  剑指 Offer 10- II. 青蛙跳台阶问题
 *  https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class ClimbStairs {

    // 爬楼梯
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            // dp[i] = (dp[i-1] + dp[i-2]) % mod;
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];
    }

    // 青蛙跳台阶
    int mod = (int) (1e9 + 7);

    public int numsWay(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            // 需要取模
             dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        return dp[n];
    }

}
