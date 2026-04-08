package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.cn/problems/cheapest-flights-within-k-stops/
 */
public class FindCheapestPrice{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int infinite = 101 * 10000 + 1;
        int[][] dp = new int[k+2][n];
        for (int i =0; i <= k +1; i++){
            Arrays.fill(dp[i],infinite);
        }
        dp[0][src] = 0;
        // k stop means need to take k + 1 flights
        for (int time = 1; time <= k+1; time++) {
            for (int[] flight : flights) {
                int flightSrc = flight[0];
                int flightDst = flight[1];
                int cost = flight[2];
                dp[time][flightDst] = Math.min(dp[time][flightDst], dp[time-1][flightSrc] + cost);
            }
        }
        int ans = infinite;
        for (int i = 0; i <= k + 1; i++){
            ans = Math.min(ans, dp[i][dst]);
        }
        // check if can't reach
        return ans ==  infinite ? -1 : ans;
    }
}
