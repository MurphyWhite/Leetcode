package src.rocks.ditto.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int n = nums.length;
        // 前缀和数组
        int[] dp = new int[n + 1];
        int ans = 0;
        // 用哈希表记住相应的值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <=n; i++){
            dp[i] = dp[i - 1] + nums[i];
            if (dp[i] == goal){
                ans++;
            }
            // 使用哈希表提高计算
            if (map.containsKey(dp[i] - goal)){
                ans += map.get(dp[i] - goal);
            }
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        return ans;
    }
}
