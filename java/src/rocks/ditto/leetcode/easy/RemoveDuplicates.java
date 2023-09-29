package src.rocks.ditto.leetcode.easy;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
            }
        }
        return left+1;
    }

    public static void main(String[] args) {

    }
}