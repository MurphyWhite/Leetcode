package src.rocks.ditto.leetcode.medium;

/**
 * 1680. 连接连续二进制数字
 * https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/description/?envType=daily-question&envId=2026-02-28
 */
public class ConcatenatedBinary {

    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            // 计算i这个数的二进制位数
            int w = 32 - Integer.numberOfLeadingZeros(i);
            // 拼接操作
            ans = ((ans << w)| i) % MOD;
        }
        return (int) ans;
    }

}
