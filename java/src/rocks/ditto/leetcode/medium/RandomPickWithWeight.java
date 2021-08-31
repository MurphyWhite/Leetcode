package src.rocks.ditto.leetcode.medium;

/**
 * 528. 按权重随机选择
 * https://leetcode-cn.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeight {

    private int[] preSum;

    public RandomPickWithWeight(int[] w) {
        this.preSum = new int[w.length + 1];
        for (int i = 1; i <= w.length; i++){
            preSum[i] = preSum[i-1] + w[i-1];
        }
    }

    // 数轴法，加二分查找
    // 随机权重算法（类似负载均衡）
    public int pickIndex() {
        int n = preSum.length;
        int t = (int) (Math.random() * preSum[n - 1]) + 1;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (preSum[mid] >= t){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 因为是从1开始的
        return r - 1;
    }
}
