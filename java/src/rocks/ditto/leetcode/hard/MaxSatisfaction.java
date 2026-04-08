package src.rocks.ditto.leetcode.hard;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 * https://leetcode.cn/problems/reducing-dishes/description/
 */
public class MaxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int curr = 0;
        // satisfaction[i] 之后的所有元素都 ≤ satisfaction[i]。如果 curr <= 0 说明加上当前这道菜后总体开始变负或为零
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            curr += satisfaction[i];
            // 如果加上这道菜
            if (curr <= 0){
                // 所以用 break 提前终止，而不是 continue 继续无意义的循环。
                break;
            }
            ans += curr;
        }
        return ans;
    }
}
