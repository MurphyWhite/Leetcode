package src.rocks.ditto.leetcode.medium;

/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 */
public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];

        // dp是从Alex从第i到第k颗的最大值和
        for (int i = 0; i < length; i++) {
            // 只有一颗的时候，alex一定要取
            dp[i][i] = piles[i];
        }

        // 状态转移方程
        for (int i = length - 2; i>=0; i--){
            for (int j=i+1; j < length; j++){
                // piles[i] - dp[i+1][j] 为选了piles[i]时的得分差值，因为要选i时，差值得分即变成对方的分数，所以使用减法而不是加法
                // piles[j] - dp[i][j-1] 为选了piles[j]时的得分差值
                dp[i][j] = Math.max(piles[i] - dp[i+1][j] , piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][length-1] > 0;
    }

    // 该规则下，alice先手必胜。永远true
    public boolean stoneGame2(int[] piles) {
        return true;
    }
}
