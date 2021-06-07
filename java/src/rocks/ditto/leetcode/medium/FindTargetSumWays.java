package src.rocks.ditto.leetcode.medium;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        // 计算绝对值总数
        for (int i : nums) {
            //s += Math.abs(i);
            s += i;
        }
        // 无达成可能
        if (target > s) {
            return 0;
        }
        // f[i][j] 代表考虑前 i 个数，当前计算结果为 j 的方案数，令 nums 下标从 1 开始。
        int[][] f = new int[n + 1][2 * s + 1];
        f[0][0 + s] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                // 如果当前x是减的话
                if ((j - x) + s >= 0) {
                    f[i][j + s] += f[i - 1][(j - x) + s];
                }
                // 如果当前x是加的话
                if ((j + x) + s <= 2 * s) {
                    f[i][j + s] += f[i - 1][(j + x) + s];
                }
            }
        }
        return f[n][target + s];
    }
}
