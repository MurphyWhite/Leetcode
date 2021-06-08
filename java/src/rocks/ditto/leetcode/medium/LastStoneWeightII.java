package src.rocks.ditto.leetcode.medium;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 */
public class LastStoneWeightII {

    //
    public int lastStoneWeightII(int[] stones){
        int n = stones.length;
        int sum = 0;
        for (int stone : stones){
            sum += stone;
        }
        int t = sum / 2;
        int[][] f = new int[n+1][t+1];
        for (int i=1; i<= n; i++){
            int stone = stones[i-1];
            for (int j=0; j <= t; j++){
                f[i][j] = f[i-1][j];
                if ( j>= stone) {
                    f[i][j] = Math.max(f[i][j], f[i-1][j-stone] + stone);
                }
            }
        }
        return Math.abs(sum - f[n][t] - f[n][t]);
    }
}
