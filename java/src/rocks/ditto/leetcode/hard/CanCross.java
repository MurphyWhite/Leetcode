package src.rocks.ditto.leetcode.hard;

/**
 * 青蛙过河
 * https://leetcode-cn.com/problems/frog-jump/
 */
public class CanCross {

    public boolean canCross(int[] stones) {
        // 青蛙每次跳跃，它的跳跃距离最多只能增加1
        // 如果i和i-1之间的距离大于i，青蛙不可能跳过
        int n = stones.length;
        for (int i = 1; i < n; i++){
            if (i < stones[i] - stones[i-1]){
                return false;
            }
        }
        // 动态规划
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        // 第几个石头
        for (int i = 1; i < n; i++){
            // 假设它是从第j颗石头跳到第i颗石头的
            for (int j = i - 1; j >= 0; j--){
                // 获取跳跃距离
                int k = stones[i] - stones[j];
                // 跳跃距离过大
                if (k > j + 1){
                    break;
                }
                // 判断是否能到达,从j跳到i
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                // 判断是否已经到达终点
                if ( i == n - 1 && dp[i][k]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,6,10,15,16,21};
        CanCross canCross = new CanCross();
        System.out.println(canCross.canCross(stones));
    }
}
