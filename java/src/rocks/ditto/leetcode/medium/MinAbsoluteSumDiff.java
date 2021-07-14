package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 1818. 绝对差值和
 * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 */
public class MinAbsoluteSumDiff {

    private int mod = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int length = nums1.length;
        // 改变后的最大差值变化
        long sum = 0, maxChange = 0;
        for (int i =0; i < length; i++) {
            int a = nums1[i] , b = nums2[i];
            // 差值
            int diff = Math.abs(a - b);
            sum += diff;

            // 尝试替换
            int l = 0, r = length - 1;
            while ( l < r){
                int mid = ( l + r ) / 2;
                if (sorted[mid] >= b) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            // 找到最接近的比b小的数，比对sorted[r] 和 sorted[r+1] 谁更接近
            int temp = Math.abs(sorted[r] - b);
            if (r + 1 < length ){
                temp = Math.min(temp, Math.abs(sorted[r - 1] - b));
            }
            // 判断变化是不是最大的
            if (diff > temp) {
                maxChange = Math.max(maxChange, diff - temp);
            }
        }

        return (int) ((sum - maxChange) % mod);
    }
}
