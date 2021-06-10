package src.rocks.ditto.leetcode.medium;

/**
 * 518. 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class Change {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        // dp背包初始值
        dp[0] = 1;
        // 这样会计算到相同的序列
//        for (int i=1; i<= amount; i++){
//            for (int coin : coins) {
//                if (i - coin >= 0){
//                    dp[i] += dp[i-coin];
//                }
//            }
//        }
        // 先循环了每种硬币的序列
        for (int coin : coins){
            for (int i = coin ; i <= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

}
