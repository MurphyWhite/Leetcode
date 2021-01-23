package src.rocks.ditto.leetcode.easy;

/**
 * 图片平滑器
 * https://leetcode-cn.com/problems/image-smoother/
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int height = M.length;
        int width = M[0].length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int tmp = M[i][j];
                int n = 1;
                if ((i - 1 >= 0) && (j - 1 >= 0)) {
                    tmp += M[i - 1][j - 1];
                    n++;
                }
                if ((i - 1 >= 0) && (j + 1 < width)) {
                    tmp += M[i - 1][j + 1];
                    n++;
                }
                if ((i - 1 >= 0)) {
                    tmp += M[i - 1][j];
                    n++;
                }
                if ((j - 1) >= 0) {
                    tmp += M[i][j - 1];
                    n++;
                }
                if ((j + 1) < width) {
                    tmp += M[i][j + 1];
                    n++;
                }
                if ((i + 1) < height) {
                    tmp += M[i + 1][j];
                    n++;
                }
                if ((i + 1 < height) && (j - 1 >= 0)) {
                    tmp += M[i + 1][j - 1];
                    n++;
                }
                if ((i + 1 < height) && (j+1 < width)){
                    tmp += M[i+1][j+1];
                    n++;
                }
                result[i][j] = tmp / n;
            }
        }
        return result;
    }
}
