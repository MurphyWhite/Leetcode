package src.rocks.ditto.leetcode.hard;

import java.util.TreeSet;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumSubmatrix {

    /**
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        // 逐层枚举
        for (int i = 0; i < m; i++){
            // 暂时记录数据
            int[] sum = new int[n];
            for (int j = i; j < m ; j++ ){
                // 逐列枚举
                for (int l = 0; l < n; l++ ){
                    sum[l] += matrix[j][l];
                }
                // 记录下i行到j行，的矩阵总和是多少
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                // 逐个判断 当前是否是最佳答案
                for (int v : sum){
                    s += v;
                    // 大于或等于给定的元素的最小元素 （大于s-k的最小元素）
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null){
                        ans = Math.max(ans , s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}
        };
        int k = 8;
        MaxSumSubmatrix solution = new MaxSumSubmatrix();
        System.out.println(solution.maxSumSubmatrix(matrix, k));
    }
}
