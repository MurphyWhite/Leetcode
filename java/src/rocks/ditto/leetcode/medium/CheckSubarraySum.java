package src.rocks.ditto.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. 连续的子数组和
 * https://leetcode-cn.com/problems/continuous-subarray-sum/submissions/
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和
        int[] sum = new int[n+1];
        for (int i=1; i<= n; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        Set<Integer> set = new HashSet<>();
        // 因为最小长度需要为２
        for (int i=2; i<=n;i++){
            // sum[i-1]不符合长度要求,i-2前的数据已经放入了set中
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)){
                return true;
            }
        }
        return false;
    }
}
