package src.rocks.ditto.leetcode.medium;

/**
 * 477. 汉明距离总和
 * https://leetcode-cn.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {

    //  太慢了，循环次数太多，不需要循环两次
    public int totalHammingDistance(int[] nums) {
        //
        int n = nums.length;
        int total = 0;
        for( int i = 0; i < n-1; i++){
            for (int j = i + 1; j < n; j++){
                total += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return total;
    }

    // 只需计算某一位上，有多少个数是1，多少个是0，相乘即可获得该位的汉明距离总和
    public int totalHammingDistance2(int[] nums) {
        int result = 0;
        int n = nums.length;
        // 因为题目的范围10的9次方小于2的30次方，所以只需要循环30次
        for (int i=0; i<30; i++){
            int c = 0;
            for (int num : nums){
                // 按位与，判断该位是不是1
                c += (num >>  i ) & 1;
            }
            // c个数是1，n-c个数是0，相乘
            result += c * (n - c);
        }
        return result;
    }
}
