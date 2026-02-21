package src.rocks.ditto.leetcode.easy;

/**
 * 762. 二进制表示中质数个计算置位
 * https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/description/?envType=daily-question&envId=2026-02-21
 */
public class CountPrimeSetBits {

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; x++){
            if (isPrime(Integer.bitCount(x))){
                System.out.println(x);
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int num){
        // 第i位是0代表，i不是质数，为y代表i是质数
        // 2，3，5，7，11，13，17，19
        int mask = 0b10100010100010101100;
        // 左移num位
        return ((1 << num) & mask) != 0;
    }

    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        countPrimeSetBits.countPrimeSetBits(10,15);
    }
}
