package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        // 首先先排序
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 2; i < n ; i++){
            int longest = nums[i];
            for (int j = i - 1; j >= 1; j--){
                for (int k = j - 1; k >= 0; k--) {
                    // 符合三角形的时候
                    if ( nums[j] + nums[k] > longest) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    // 使用双指针
    public int triangleNumberTwoPointer(int[] nums) {
        // 首先先排序
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 2; i < n ; i++){
            // 双指针遍历，降低里面的循环
            // k是最小值，j是较大值
            // 固定最大边和次大边，进行遍历
            for (int j = i - 1, k = 0; k < j; j--){
                // 如果达不到三角形的条件，就继续缩小范围
                while ( k < j && nums[k] + nums[j] <= nums[i]) {
                    k++;
                }
                ans += j - k;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int start, int end) {
        return true;
    }
}
