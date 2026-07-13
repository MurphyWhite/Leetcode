package src.rocks.ditto.leetcode.hard;
/**
 * 3336. 最大公约数相等的子序列数量
 * https://leetcode.cn/problems/find-the-number-of-subsequences-with-equal-gcd/description/?envType=daily-question&envId=2026-07-13
 */
public class SubsequencePairCount {

    public int subsequencePairCount(int[] nums) {
        int mod = 10_9 + 7;
        int length = nums.length;
        int max = nums[length - 1];
        
        // GCD pair
        int[][][] dp = new int[nums.length + 1][max+1][max+1];
        
        
        return 0;
    }
}
