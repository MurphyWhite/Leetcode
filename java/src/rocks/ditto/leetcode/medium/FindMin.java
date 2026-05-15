package src.rocks.ditto.leetcode.medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=daily-question&envId=2026-05-15
 */
public class FindMin {

    public int findMin(int[] nums) {

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
