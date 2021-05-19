package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 找出第 K 大的异或坐标值
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 **/
public class KthLargestValue {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m+1][n+1];
        // 记录结果
        List<Integer> result = new ArrayList<>();
        // 前缀和矩阵
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                // 获取(i,j)的前缀和，注意pre和matrix的关系
                pre[i][j] = pre[i-1][j] ^ pre[i][j-1] ^ pre[i-1][j-1] ^ matrix[i - 1 ][j - 1];
                result.add(pre[i][j]);
            }
        }

        // 排序后，获取第k大
        Collections.sort(result, (o1, o2) -> o2 - o1);
        return result.get(k - 1);
    }

    public static void main(String[] args) {
        KthLargestValue solution = new KthLargestValue();
        int[][] a = new int[][]{{5,2}, {1,6}};
        solution.kthLargestValue(a, 1);
    }
}
