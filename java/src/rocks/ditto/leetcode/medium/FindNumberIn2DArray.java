package src.rocks.ditto.leetcode.medium;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        // 类似二叉树
        // 从右上角开始查找,或者可以从左下角开始查找
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while ((x < m) && (y >= 0)) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num > target){
                // num大于target,向矩阵下方移动
                x++;
            } else {
                // num小于target，向矩阵左边移动
                y--;
            }
        }
        return false;
    }
}
