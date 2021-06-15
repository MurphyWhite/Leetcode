package src.rocks.ditto.leetcode.easy;

/**
 * 852. 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInMountainArray {

    // 2分法
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            int result = arr[mid];
            // 因为arr的长度至少为3，所以可以不用判断index溢出
            boolean leftTemp = result > arr[mid - 1];
            boolean rightTemp = result > arr[mid + 1];
            // 就是山峰
            if (leftTemp && rightTemp){
                return mid;
            }
            // 山峰左侧
            if (leftTemp){
                left = mid + 1;
            }
            // 山峰右侧
            if (rightTemp) {
                right = mid;
            }
        }
        return left;
    }

    // 3分法 (每次排除3分之2的区间)
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2;
        while (left < right){
            int m = (right - left) / 3;
            int m1 = left + m, m2 = right - m;
            if (arr[m1] > arr[m1+1]) {
                right = m1;
            } else if (arr[m2] < arr[m2 + 1]) {
                left = m2 + 1;
            } else {
                left = m1 + 1;
                right = m2;
            }
        }
        return left;
    }
}
