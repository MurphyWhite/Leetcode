package src.rocks.ditto.leetcode.easy;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Fib {

    private int mod = (int) 1e9 + 7;

    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        // 使用dp列表节省时间
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            // 防止溢出,结果需要乘
            dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(50));
        System.out.println(fib.fib(50) % 1000000007);
        System.out.println(Integer.MAX_VALUE);
    }
}
