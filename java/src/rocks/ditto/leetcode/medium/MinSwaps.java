package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 1536. 排布二进制网格的最少交换次数
 * https://leetcode.cn/problems/minimum-swaps-to-arrange-a-binary-grid/description/?envType=daily-question&envId=2026-03-02
 */
public class MinSwaps {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        // 先算出最后一个1的地方
        int[] pos = new int[n];
        Arrays.fill(pos, -1);

        for (int i = 0; i < n; i++) {
            // 从后往前遍历
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = -1;
            // 先找到适合现在这行的
            for (int j = i; j < n; j++) {
                // 这个适合
                if (pos[j] <= i) {
                    k = j;
                    ans += j - i;
                    break;
                }
            }
            // 能够找到适合的
            // 要做交换
            if (k >= 0) {
                for (int j = k; j > i; --j) {
                    int temp = pos[j];
                    pos[j] = pos[j - 1];
                    pos[j - 1] = temp;
                }
            } else {
                // 找不到就是不行
                return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,0,0},{1,1,0},{1,1,1}};

        int[][] grid2 = new int[][]{{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}};

        MinSwaps minSwaps = new MinSwaps();
        System.out.println(minSwaps.minSwaps(grid1));  // 输出: 0
        System.out.println(minSwaps.minSwaps(grid2));  // 输出: -1
    }
}
