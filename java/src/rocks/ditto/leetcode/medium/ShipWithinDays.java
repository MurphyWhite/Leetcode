package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/***
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int D) {
        // 船的载重量不能小于任何一个包裹的重量
        int min = Arrays.stream(weights).max().getAsInt();
        int max = Arrays.stream(weights).sum();
        while (min < max){
            int mid = (min + max)/2;
            // 需要运送的天数
            int need = 1;
            // 当前一天的运送包裹的重量之和
            int cur = 0;
            for (int weight : weights){
                // 贪心，尽量多装（因为是按顺序装，所以可以用这种办法）
                if (cur + weight > mid){
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D){
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        return max;
    }
}
