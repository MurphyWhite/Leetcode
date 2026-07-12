package src.rocks.ditto.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A University has invited N alumni for a dinner. The dinner table has a circular shape. Each alumnus is assigned an invitation ID from 0 to N-1. Each alumnus likes exactly one fellow alumnus and will attend the dinner only if he/she can be seated next to the person he/she likes.
 *
 * Write an algorithm to find the IDs of the alumni in a lexicographical order so that maximum number of alumni attend the dinner. If more than one such seating arrangement exists, then output the one that is lexicographically smaller.
 *
 * 2127. 参加会议的最多员工数
 * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/
 */
public class MaximumInvitations {
    public List<Integer> maximumInvitations(int[] favorite) {
        int n = favorite.length;
        // in 统计每个节点的入度情况, max 统计每节点的最长链
        int[] in = new int[n],
                // the array sort the link max length from i
                max = new int[n];
        // 记录每个节点的前驱节点（拓扑排序后用于回溯链）
        List<List<Integer>> prev = new ArrayList<>();
        for (int i = 0; i < n; i++) prev.add(new ArrayList<>());

        for (int x : favorite) in[x]++;
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) d.addLast(i);
        }
        // 拓扑排序
        while (!d.isEmpty()) {
            int cur = d.pollFirst(), ne = favorite[cur];
            max[ne] = Math.max(max[ne], max[cur] + 1);
            prev.get(ne).add(cur);
            if (--in[ne] == 0) d.addLast(ne);
        }

        // 圆桌最多放置一个大于 2 的环（ans1 统计最大值）
        // 圆桌可放置多个等于 2 的环（ans2 累加该长度）
        int ans1 = 0, ans2 = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) continue;
            int j = favorite[i], cur = 1;
            while (j != i) {
                in[j] = 0;
                j = favorite[j];
                cur++;
            }
            if (cur == 2) {
                int a = i, b = favorite[i];
                // 收集 a 及其前驱链
                List<Integer> chainA = new ArrayList<>();
                collectChain(a, prev, max, chainA);
                // 收集 b 及其前驱链
                List<Integer> chainB = new ArrayList<>();
                collectChain(b, prev, max, chainB);
                // 构建结果: chainA + a + b + chainB
                List<Integer> candidate = new ArrayList<>(chainA);
                candidate.add(a);
                candidate.add(b);
                candidate.addAll(chainB);
                ans2 += candidate.size();
                if (ans2 > ans1) {
                    ans1 = ans2;
                    result = candidate;
                }
            }
            else {
                // 收集环上的所有节点
                List<Integer> cycle = new ArrayList<>();
                j = i;
                do {
                    cycle.add(j);
                    j = favorite[j];
                } while (j != i);
                cycle.sort(Integer::compareTo);
                if (cycle.size() > ans1) {
                    ans1 = cycle.size();
                    result = cycle;
                }
            }
        }
        result.sort(Integer::compareTo);
        return result;
    }

    private void collectChain(int node, List<List<Integer>> prev, int[] max, List<Integer> chain) {
        // 找到最长链的前驱
        int cur = node;
        while (!prev.get(cur).isEmpty()) {
            int next = prev.get(cur).get(0);
            // 找最大权值的前驱
            for (int p : prev.get(cur)) {
                if (max[p] > max[next]) next = p;
            }
            if (max[next] == 0) break;
            chain.add(next);
            cur = next;
        }
    }
}
