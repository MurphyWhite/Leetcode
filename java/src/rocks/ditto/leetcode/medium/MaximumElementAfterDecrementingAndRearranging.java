package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 1846. 减小和重新排列数组后的最大元素
 * https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 */
public class MaximumElementAfterDecrementingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        /**
         * 初始值必须为1，所以最大值范围一定是[1, n-1]
         */
        int temp = 1;
        for (int num : arr) {
            // arr[i] == arr[i - 1] 的时候，不能增加
            if (num == temp) {
                continue;
            }
            // 贪心算法，满足情况可以+1 arr[i] >= arr[i - 1] + 1
            if (num > temp && temp <= n - 1) {
                temp++;
            }
        }
        return temp;
    }

    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        // 数组必须以1开头
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
            // arr[i] 和 arr[i - 1] 差值为0，1时，代表数字正确，不需要调整
            // 大于1以上的需要调整成大于1
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging solution = new MaximumElementAfterDecrementingAndRearranging();
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
    }
}
