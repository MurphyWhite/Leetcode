package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 3741. 三个相等元素之间的最小距离 II
 * https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-ii/description/?envType=daily-question&envId=2026-04-11
 */
public class MinimumDistance {

    public int minimumDistance(int[] nums) {
        int n = nums.length;
        // the link array of same number
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Map<Integer, Integer> map = new HashMap<>();
        // start from end , put the nums last place
        for (int i = n-1; i >= 0; i--) {
            // put the next one
            if (map.containsKey(nums[i])) {
                next[i] = map.get(nums[i]);
            }
            // replace the last one
            map.put(nums[i], i);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n-1; i++) {
            int second = next[i];
            // exist the second one
            if (second != -1) {
                int third = next[second];
                if (third != -1) {
                    ans = Math.min(ans, Math.abs(third - i));
                }
            }
        }
        return ans ==  Integer.MAX_VALUE ? -1 : (ans * 2);
    }
}
