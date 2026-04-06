package src.rocks.ditto.leetcode.hard;

import java.util.Arrays;

/**
  * 1928. Minimum Cost to Reach Destination in Time
  * https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/submissions/715704888/
 */
public class MinCost {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int cityNum = passingFees.length;
        int[][] dp = new int[maxTime+1][cityNum+1];

        // initial the dp
        for (int i = 0; i <= maxTime; i++) {
            // means unreachable
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // start point
        dp[0][0] = passingFees[0];

        // start time
        for (int t = 1; t <= maxTime; t++) {
            for (int[] edge : edges) {
                int source = edge[0];
                int destination = edge[1];
                int cost = edge[2];
                // maybe wasn't come from this link
                if (cost <= t){
                    // previous point are available, pay the money when reached
                    if (dp[t - cost][source] != Integer.MAX_VALUE) {
                        dp[t][destination]  = Math.min(dp[t - cost][source] + passingFees[destination], dp[t][destination]);
                    }
                    if (dp[t - cost][destination] != Integer.MAX_VALUE) {
                        dp[t][source]  = Math.min(dp[t - cost][destination] + passingFees[source], dp[t][source]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int t = 1; t <= maxTime; t++) {
            ans = Math.min(ans, dp[t][cityNum-1]);
        }

        if (ans == Integer.MAX_VALUE) {
            // unreachable
            return -1;
        } else {
            return ans;
        }
    }
}

