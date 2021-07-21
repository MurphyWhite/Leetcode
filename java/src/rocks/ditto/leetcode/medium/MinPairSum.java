package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 * https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 */
public class MinPairSum {

    public int minPairSum(int[] nums) {

        // 先排序数组
        // 根据贪心算法,猜测需要 nums[i] + nums[n-i] 组成数对，此时的最大数对和最小
        // 排序后的第i个和倒数第i个元素必须成对
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0, right = length - 1;
        int sum = Integer.MAX_VALUE;
        while (left < right){
            // 求最大数对和
            sum = Math.min(nums[left++] + nums[right--] , sum);
        }
        return sum;
    }
}
