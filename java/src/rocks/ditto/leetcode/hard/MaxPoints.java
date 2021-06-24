package src.rocks.ditto.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 * https://leetcode-cn.com/problems/max-points-on-a-line/
 */
public class MaxPoints {

    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        // 遍历点
        for (int i=0; i < n; i++){
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i+1; j < n; j++){
                // 计算斜率
                int deltaX = points[j][1] - points[i][1];
                int deltaY = points[j][0] - points[i][0];
                // 通过计算最大公约数计算斜率，
                // slope = deltaY/ deltaX
                // 因为浮点数有精度问题，所以用分数表示，分数要最简分数
                // 所以先求最大公约数
                int gcd = gcd(deltaX, deltaY);
                String slope = deltaX / gcd + "/" + deltaY / gcd;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    // 获取最大公约数
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);

    }
}
