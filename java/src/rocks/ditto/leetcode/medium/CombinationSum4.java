package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int num : nums){
                if (num <= i){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    /**
     * 用nums凑出target数，要求用的数字最小
     *
     * @param nums
     * @param target
     * @return
     */

    public int combinationSum(int[] nums, int target){
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= target; i++){
            for (int num : nums) {
                if (i - num >=0 && dp[i - num] != -1){
                    dp[i] = dp[i] == -1 ? dp[i - num] + 1 : Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,4};
        CombinationSum4 solution = new CombinationSum4();
        System.out.println(solution.combinationSum(nums1, 10));
        System.out.println(solution.combinationSum(nums1, 20));
        System.out.println(solution.combinationSum(nums1, 7));
    }
}
