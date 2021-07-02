package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 * https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 */
public class MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        Integer last = coins;
        Integer iceCream = 0;
        // 这个排序的时间复杂度是nlogn(双轴排序)
        Arrays.sort(costs);
        // 贪心算法
        for (int cost : costs){
            if (last == 0){
                return iceCream;
            }
            if (last >= cost){
                last -= cost;
                iceCream++;
            }
        }
        return iceCream;
    }

}
