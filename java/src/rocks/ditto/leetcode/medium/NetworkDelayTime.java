package src.rocks.ditto.leetcode.medium;

/**
 * 743. 网络延迟时间
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class NetworkDelayTime {

    //跑一遍 Floyd，可以得到「从任意起点出发，到达任意起点的最短距离」。然后从所有 w[k][x]w[k][x] 中取 maxmax 即是「从 kk 点出发，到其他点 xx 的最短距离的最大值」。

    // 无穷大
    private int INF = 0x3f3f3f3f;

    // 主要是多源头汇聚
    public int networkDelayTimeFloyd(int[][] times, int n, int k) {
        int[][] matrix = new int[n + 1][n + 1];
        int[][] floyd = new int[n + 1][n + 1];
        // 先构建邻接图
        for (int i = 1; i <=n ; i++){
            for (int j = 1; j <= n; j++) {
                floyd[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] time : times) {
            int s = time[0], d = time[1], c = time[2];
            floyd[s][d] = c;
        }

        // Floyd
        // p中转点
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][p] + floyd[p][j]);
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++){
            // 判断是否有不可达的情况
            // 有负权边的时候可以 >= INF/2， 使得没有通路的节点联通的时候小于 INF
            if (floyd[k][i] == INF) {
                return -1;
            }
            ans = Math.max(ans, floyd[k][i]);
        }
        return ans;
    }


    // dij算法， 单源头
    // TODO: 2021/8/3 复习dij算法

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        solution.networkDelayTimeFloyd(new int[][] { {2,1,1},{2,3,1},{3,4,1}}, 4, 2);
    }
}
