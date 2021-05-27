package src.rocks.ditto.leetcode.easy;

/**
 * 461. 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistance {

    int hammingDistance(int x, int y) {
        //  计算x和y的不同位，就是异或
        int diff = x ^ y;
        return Integer.bitCount(diff);
    }

    //bit count 算法是什么
    public static int bitCount(int i) {
        // 
        i = (i & 0x55555555) + ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i & 0x0f0f0f0f) + ((i >>> 4) & 0x0f0f0f0f);
        i = (i & 0x00ff00ff) + ((i >>> 8) & 0x00ff00ff);
        i = (i & 0x0000ffff) + ((i >>> 16) & 0x0000ffff);
        return i;
    }
}
