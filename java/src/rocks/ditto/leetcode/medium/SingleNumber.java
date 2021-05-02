package src.rocks.ditto.leetcode.medium;

/**
 * 只出现一次的数字II
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i=0; i < 32; i++){
            int total = 0;

            for (int num : nums){
                // 只有一个数字会出现1次，所以其他的数字都可以被3整除
                // 把数转为32位的二进制数，然后把每一位加起来
                if (((num >> i) & 1) == 1){
                    total++;
                }
            }
            // 判断当前位置是否可被3整除，不可以的话就加到答案中
            if (total % 3 == 1){
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}
