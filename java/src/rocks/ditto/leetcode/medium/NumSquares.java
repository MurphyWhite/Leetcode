package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquares {

    // 转移方程
    //f[j]=min(f[j],f[j−t]+1)
    public int numSquares(int n) {
        // 背包问题
        int f[] = new int[n+1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i=1; i * i <= n; i++){
            int t = i * i;
            for (int j=t; j <=n; j++){
                // 判断是不是
                f[j] = Math.min(f[j], f[j-t] + 1);
            }
        }
        return f[n];
    }
}
