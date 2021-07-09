package src.rocks.ditto.leetcode.easy;

/**
 * 面试题 17.10. 主要元素
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class MajorityElement {

    public int majorityElement(int[] nums){
        int n = nums.length;
        int temp = -1, count = 0;
        // 如果数字超过半数，一定能留下
        for (int num : nums) {
            if (count == 0){
                temp = num;
                count++;
            } else {
                count += temp == num ? 1 : -1;
            }
        }
        count = 0;
        // 检验是不是超过半数
        for (int num : nums) {
            if (temp == num) {
                count++;
            }
        }
        return count > n / 2 ? temp : -1;
    }
}
