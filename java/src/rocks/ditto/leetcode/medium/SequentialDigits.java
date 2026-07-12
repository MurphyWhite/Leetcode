package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. Sequential Digits
 * https://leetcode.cn/problems/sequential-digits/description/?envType=daily-question&envId=2026-07-13
 */
class SequentialDigits {

    // 所有连续数字一共只有36个，预计算打表
    private static final int[] ALL = {
        12, 23, 34, 45, 56, 67, 78, 89,
        123, 234, 345, 456, 567, 678, 789,
        1234, 2345, 3456, 4567, 5678, 6789,
        12345, 23456, 34567, 45678, 56789,
        123456, 234567, 345678, 456789,
        1234567, 2345678, 3456789,
        12345678, 23456789,
        123456789
    };

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int num : ALL) {
            if (num > high) break;  // 已排序，后面都更大
            if (num >= low) result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        SequentialDigits solution = new SequentialDigits();
        System.out.println(solution.sequentialDigits(100, 300)); // 输出: [123, 234]
        System.out.println(solution.sequentialDigits(1000, 13000)); // 输出: [1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }
}
