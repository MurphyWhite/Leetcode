package src.rocks.ditto.leetcode.easy;

import java.util.Arrays;

/**
 * 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int j = nums.length;
        for (int i = 0; i < j; i++) {
            while (nums[i] == val && i < j) {
                nums[i] = nums[--j];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int nums[] = {2, 4, 3, 2};
        int val = 2;
        RemoveElement solution = new RemoveElement();
        System.out.println(solution.removeElement(nums, val));
        Arrays.stream(nums).forEach(System.out::print);
    }
}
