package src.rocks.ditto.leetcode.easy;

/**
 * 693. 交替位二进制数
 * https://leetcode.cn/problems/binary-number-with-alternating-bits/description/?envType=daily-question&envId=2026-02-18
 */
public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        // 按位 异或 1^0=1 0^1=1 1^1=0 0^0=0
        int a = n ^ (n >> 1);
        // 如果是交替10的话，a既是1111111
//        System.out.println(a);
        return (a & (a + 1)) == 0;
    }

    public static void main(String[] args) {

        HasAlternatingBits hasAlternatingBits = new HasAlternatingBits();
        System.out.println(hasAlternatingBits.hasAlternatingBits(0b101));
        System.out.println(hasAlternatingBits.hasAlternatingBits(0b10101));
    }
}
