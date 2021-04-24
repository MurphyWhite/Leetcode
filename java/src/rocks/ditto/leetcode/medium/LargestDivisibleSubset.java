package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // nums[i] 是nums[j]的倍数的话，那么可以得到一个更大的整除子集（下面的2）
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        // 倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int k = n - 1; k >= 0 && maxSize > 0; k--) {
            if ((dp[k] == maxSize) && (maxVal % nums[k] == 0)) {
                res.add(nums[k]);
                maxVal = nums[k];
                maxSize--;
            }
        }
        return res;
    }

    /**
     * 整除的传递性，即如果 a｜b，并且 b｜c ,  那么a｜c,
     * 1. 如果整数a是整除子集S1的最小整数b的约数（即 a∣b），那么可以将 a 添加到 S1中得到一个更大的整除子集
     * 2. 如果整数c是整除子集S2的最大整数d的倍数（即 d|c），那么可以将 c 添加到 S2中得到一个更大的整除子集。
     **/

    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();
        int[] nums = new int[]{3, 4, 8, 16};
        List<Integer> res = solution.largestDivisibleSubset(nums);
        res.forEach(System.out::print);
    }
}
