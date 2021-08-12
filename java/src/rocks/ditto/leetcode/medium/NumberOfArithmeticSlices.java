package src.rocks.ditto.leetcode.medium;

/**
 * 413. 等差数列划分
 * https://leetcode-cn.com/problems/arithmetic-slices/
 */
public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int d = nums[1] - nums[0], t = 0, ans = 0;
        for (int i = 2; i < n; i++){
            if (nums[i] - nums[i - 1] == d) {
                t++;
            } else {
                d = nums[i] - nums[i - 1];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public int numberOfArithmeticSlicesTwoPointer(int[] nums) {

        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n - 2; ){
            int j = i, d = nums[i + 1] - nums[i];
            // 假如符合等差数列的条件， j一直加
            while (j + 1 < n && nums[j+1] - nums[j] == d) {
                j++;
            }
            // 计算该数列能分解成多少个子数列
            int len = j - i + 1;
            // a1：长度为 len 的子数组数量；an：长度为 3 的子数组数量
            int a1 = 1, an = len - 3 + 1;
            // 所以数列数量 = a1 + a2 + ... + an
            int count = (a1 + an) * an / 2;
            ans += count;
            // i从右边继续开始
            i = j;
        }
        return ans;
    }

}
