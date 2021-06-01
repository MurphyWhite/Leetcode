package src.rocks.ditto.leetcode.medium;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 */
public class CanEat {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        int n = queries.length, m = candiesCount.length;
        boolean[] ans = new boolean[n];
        long[] sum = new long[m+1];
        // 第i种糖的前缀和有多少（第0种糖前面只有0，sum[0]=0）
        for (int i = 1; i <= m; i++){
            sum[i] = sum[i-1] + candiesCount[i-1];
        }
        for(int j=0; j<n; j++){
            // 最喜欢的糖类
            int candy = queries[j][0];
            // 最喜欢的日子
            int day = queries[j][1] + 1;
            //
            int eat = queries[j][2];
            // 最快的速度吃
            long min = sum[candy] / eat + 1;
            // 最慢每天吃一颗
            long max = sum[candy+1];
            // 只要最快和最慢的区间在包含了day，就可以吃到
            ans[j] = min <= day && day <= max;
        }
        return  ans;
    }
}
