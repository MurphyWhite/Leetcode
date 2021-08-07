package src.rocks.ditto.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 847. 访问所有节点的最短路径
 * https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/
 */
public class ShortestPathLength {

    int INF = 0x3f3f3f3f;

    // 状态压缩 + dp
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        // 初始化距离, 距离无穷远
        // (state, u) 状态，目的地
        int[][] distance = new int[mask][n];
        for (int i = 0; i < mask; i++) {
            Arrays.fill(distance[mask], INF);
        }

        Deque<int[]> deque = new ArrayDeque<>();

        // (10, 1) 代表从 第一个节点到第一个节点距离是0
        for (int i = 0; i < n; i++) {
            distance[1 << i][i] = 0;
            // 先将起点状态入队
            deque.addLast(new int[]{1 << i, i});
        }

        // BFS过程
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int state = poll[0], u = poll[1], step = distance[state][u];
            // 所有位都已经遍历过
            if (state == mask - 1) return step;
            for (int i : graph[u]) {
                // 如果从u 到 i之前没有更新过距离
                if (distance[state | (1 << i)][i] == INF) {
                    distance[state | (1 << i)][i] = step + 1;
                    // 将这个状态加进队列中
                    deque.addLast(new int[]{state | (1 << i), i});
                }
            }
        }
        return -1;
    }

    // floyd + 状态压缩
    public int shortestPathLengthFloyd(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        // floyd求两点之间的距离
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int dst : graph[i]) {
                dist[i][dst] = 1;
            }
        }

        // floyd 算法, 经过p点
        for (int p = 0; p < n; p++) {
            for (int src = 0; src < n; src++) {
                for (int dst = 0; dst < n; dst++) {
                    dist[src][dst] = Math.min(dist[src][dst], dist[src][p] + dist[p][dst]);
                }
            }
        }

        //dp 过程, 通过上面floyd算法算出来的距离进行转移
        int[][] dp = new int[mask][n];

        // 起始时，让所有状态的最短距离（步长）为正无穷
        for (int i = 0; i < mask; i++) {
            Arrays.fill(dp[i], INF);
        }
        // 将起点设置为0
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        // 枚举所有的state
        for (int state = 0; state < mask; state++) {
            // 枚举中间点
            for (int i = 0; i < n; i++) {
                // 如果当前状态i点是没有经过的
                if ((state >> i & 1) == 0) {
                    continue;
                }
                // 如果当前状态i点是已经经过过的
                // 枚举j目的地
                for (int j = 0; j < n; j++) {
                    dp[state | (1 << j)][j] = Math.min(dp[state | 1 << j][j], dp[state][i] + dist[i][j]);
                }
            }
        }
        int ans = INF;
        for (int i = 0; i < n; i++){
            ans = Math.min(ans, dp[mask - 1][i]);
        }
        return ans;
    }
}
