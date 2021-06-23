package src.rocks.ditto.leetcode.easy;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {

    public int hammingWeight(int n){
        // 直接返回1的位数
        //return Integer.bitCount(n);
        // 使用lowbit
        int ans = 0;
        for (int i = n; i > 0 ; i -= lowbit(i)){
            ans++;
        }
        return ans;
    }

    // lowbit 返回x最低位1的数 1100 返回 100
    private int lowbit(int x){
        return x & -x;
    }
}
