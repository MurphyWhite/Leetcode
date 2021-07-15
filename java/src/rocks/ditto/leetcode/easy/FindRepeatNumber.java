package src.rocks.ditto.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> repeatSet = new HashSet<>();
        for (int num : nums){
            if (repeatSet.contains(num)) {
                return num;
            } else {
                repeatSet.add(num);
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> repeatSet = new HashSet<>();
        for (int num : nums){
            // 不能加入的话，证明已经出现过了
            if (!repeatSet.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
