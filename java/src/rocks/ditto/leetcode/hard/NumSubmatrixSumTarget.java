package src.rocks.ditto.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] mat, int t) {

        // 构建前缀和矩阵
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for (int i=1; i <= m; i++){
            for (int j=1; j<=n; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int ans = 0;
        for ( int top=1; top<=m; top++){
            for ( int bot = top; bot <=m; bot++){
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int r = 1; r <= n; r++){
                    //  矩阵（top-1,r , bot, r）的元素和
                    cur = sum[bot][r] - sum[top-1][r];
                    if (cur == t){
                        ans++;
                    }
                    // 假如cur这个数比较大，找找有没有刚好等于cur - t矩阵，
                    if (map.containsKey(cur - t)){
                        // 如果有，减去那些矩阵，就能符合t的要求
                        ans += map.get(cur - t);
                    }
                    // 把现有矩阵的值放入map中进行统计
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
}
