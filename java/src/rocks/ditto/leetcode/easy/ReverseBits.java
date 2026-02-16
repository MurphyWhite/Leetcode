package src.rocks.ditto.leetcode.easy;

/**
 *
 * https://leetcode.cn/problems/reverse-bits/?envType=daily-question&envId=2026-02-16
 */
public class ReverseBits {

    /**
     * 32 位有符号整数
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int m0 = 0b01010101010101010101010101010101;
        int m1 = 0b00110011001100110011001100110011;
        int m2 = 0b00001111000011110000111100001111;
        int m3 = 0b00000000111111110000000011111111;
        int m4 = 0b00000000000000001111111111111111;

        n = ((n >> 1) & m0) | ((n & m0) << 1);
        n = ((n >> 2) & m1) | ((n & m1) << 2);
        n = ((n >> 4) & m2) | ((n & m2) << 4);
        n = ((n >> 8) & m3) | ((n & m3) << 8);
        n = ((n >> 16) & m4) | ((n & m4) << 16);
        return n;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        System.out.println(solution.reverseBits(2147483644));
    }
}
