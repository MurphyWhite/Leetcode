package src.rocks.ditto.leetcode.medium;

/**
 * 581. 最短无序连续子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class FindUnsortedSubarray {

    int MIN = -100005, MAX = 100005;

    public int findUnsortedSubarray(int[] nums) {
        int i = 0, j = nums.length - 1;
        // 找单调递增的右端点
        while (i < j && nums[i] <= nums[i+1]) {
            i++;
        }
        // 找单调递增的左端点
        while (i < j && nums[j] >= nums[j - 1]) {
            j--;
        }
        int l = i, r = j;
        int min = nums[i], max = nums[j];
        // 遍历非单调的数组段，查找该段中的最大值和最小值
        for (int k = l; k <= r; k++){
            if (nums[k] < min) {
                while ( i >= 0 && nums[i] > nums[k]) {
                    i--;
                }
                // 如果i已经到了数组左边界(-1)了，那就不需要考虑
                min = i >= 0 ? nums[i] : MIN;
            }
            if (nums[k] > max) {
                while ( j <= nums.length - 1 && nums[j] < nums[k]) {
                    j++;
                }
                // 如果j已经到了数组右边界(n)了，那就不需要考虑
                max = j <= nums.length - 1 ? nums[j] : MAX;
            }
        }
        return j == i ? 0 : (j - 1) - (i + 1) + 1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray f = new FindUnsortedSubarray();
        f.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15});
    }
}
