package src.rocks.ditto.leetcode.easy;

/**
 * 1486. 数组异或操作
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class XorOperation {

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++){
            res ^= start + 2 * i;
        }
        return res;
    }

}
