package src.rocks.ditto.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2553. Separate the Digits in an Array
 *  https://leetcode.cn/problems/separate-the-digits-in-an-array/description/?envType=daily-question&envId=2026-05-11
 */
public class SeparateDigits {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int x = nums[i]; x > 0; x/=10) {
                list.add(x % 10);
            }
        }
        int m = list.size();
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = list.get(m - i - 1);
        }
        return res;
    }
}
