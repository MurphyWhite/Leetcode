package src.rocks.ditto.leetcode.easy;

/**
 * 1646. 获取生成数组中的最大值
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 */
public class GetMaximumGenerated {

    private static int[] RESULT = new int[101];

    static {
        RESULT[0] = 0;
        RESULT[1] = 1;
        for (int i = 2; i < 101; i++) {
            if (i % 2 == 1) {
                RESULT[i] = RESULT[i / 2] + RESULT[i / 2 + 1];
            } else {
                RESULT[i] = RESULT[i / 2];
            }
        }

        for (int i = 0, max = 0; i < 101; i++){
            RESULT[i] = max = Math.max(max, RESULT[i]);
        }
    }

    public int getMaximumGenerated(int n) {
        return RESULT[n];
    }
}
