package src.rocks.ditto.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 * https://leetcode-cn.com/problems/brick-wall/
 */
public class LeastBricks {

    //问题可以转换成求「垂线穿过的砖块边缘数量的最大值」，用砖墙的高度减去该最大值即为答案。
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> noCrossBricksMap = new HashMap<>();
        int n = wall.size();
        for (int i = 0; i < n ; i++){
            int shade = 0;
            // 遍历该层的所有砖的边缘位置
            for (int brick : wall.get(i)){
                // 边缘位置加砖的长度等于边缘位置
                shade += brick;
                noCrossBricksMap.put(shade, noCrossBricksMap.getOrDefault(shade, 0) + 1);
            }
            noCrossBricksMap.remove(shade);
        }
        // 答案最大值为砖墙的高度
        int ans = n;
        for (Integer noCross : noCrossBricksMap.values()){
            ans = Math.min(ans, n - noCross);
        }
        return ans;
    }

}
