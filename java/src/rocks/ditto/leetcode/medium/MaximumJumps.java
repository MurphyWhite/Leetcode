package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 2770. 达到末尾下标所需的最大跳跃次数
 * https://leetcode.cn/problems/maximum-number-of-jumps-to-reach-the-last-index/?envType=daily-question&envId=2026-05-10
 */
public class MaximumJumps {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (Math.abs(nums[j] - nums[i]) <= target) {
                    if (dp[i] == -1) continue;
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        if (dp[n - 1] == n + 1) return -1;
        else return dp[n - 1];
    }
}
