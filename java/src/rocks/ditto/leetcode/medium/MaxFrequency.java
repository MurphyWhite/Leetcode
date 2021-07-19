package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 */
public class MaxFrequency {

    // 入参数组
    private int[] nums;
    // 前缀和
    private int[] sums;
    // 可操作数量
    private int k;
    // 数组总长度
    private int n;

    public int maxFrequency(int[] nums, int k) {
        this.nums = nums;
        Arrays.sort(this.nums);
        this.n = nums.length;
        this.k = k;
        // 处理前缀和数组
        this.sums = new int[n + 1];
        sums[0] = 0;
        for (int i=1; i <= n; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }

        // 最高频范围[0, n]
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r / 2 + 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    // 判断最高频是否可为len
    private boolean check(int len){
        for (int i = 0; i + len - 1 < n; i++){
            // 检查范围是否可以实现
            int diff = len * nums[i + len - 1] - (sums[i + len] - sums[i]);
            if (diff <= k) {
                return true;
            }
        }
        return false;
    }
}
