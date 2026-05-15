package src.rocks.ditto.leetcode.easy;

import java.util.Arrays;

/**
 * 2784. Check if Array is Good
 * https://leetcode.cn/problems/check-if-array-is-good/?envType=daily-question&envId=2026-05-14
 */
public class IsGood {

    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1){
                return false;
            }
        }
        return nums[n] == n;
    }

}
