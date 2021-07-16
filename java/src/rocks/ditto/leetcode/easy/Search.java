package src.rocks.ditto.leetcode.easy;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Search {

    public int search(int[] nums, int target) {
        // nums是排序好的数组
        int n = nums.length;

        // 特殊处理空数组的情况
        if (n == 0) {
            return 0;
        }

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (r + l) / 2 + 1;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans = 0;
        // 特殊处理一下target是两边边界的情况
        // target == nums[0] || target == nums[n - 1]
        if (nums[r] == target){
            ans++;
        }
        int temp = r + 1;
        while ( temp < n && nums[temp++] == target){
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 8, 8};
        Search search = new Search();
        search.search(nums, 8);
    }
}
