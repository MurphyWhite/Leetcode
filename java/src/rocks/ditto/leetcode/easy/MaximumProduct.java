package src.rocks.ditto.leetcode.easy;

/**
 * 628. 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProduct {

    // 如果全是正数或全是负数， 最大3个乘积。
    // 如果只有一个数>=0,取最大的数（正数，0）和最小的两个数（负数）
    // 只有两个正数时，取最大的三个数（2个正数，和一个最大的负数）
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;

            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}
