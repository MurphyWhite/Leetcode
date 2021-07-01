package src.rocks.ditto.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LCP 07. 传递信息
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 */
public class NumWays {

    //有向图
    Map<Integer, Set<Integer>> relationMap = new HashMap<>();

    int ans = 0, k, n;

    public int numWays(int n, int[][] relations, int k) {
        this.k = k;
        this.n = n;
        // 先构造有向图
        for (int[] relation : relations){
            int from = relation[0], to = relation[1];
            Set<Integer> set = relationMap.getOrDefault(from, new HashSet<>());
            set.add(to);
            relationMap.put(from, set);
        }
        dfs(0, 0);
        return ans;
    }

    // 深搜获取结果
    private void dfs(int curPerson, int step){
        // 到达了步数
        if (step == k){
            // 传递到需要的人
            if (curPerson == n - 1){
                ans++;
            }
            return;
        }
        Set<Integer> set = relationMap.get(curPerson);
        if (set == null) {
            return;
        }
        // 传给下一个人
        for (int next : set){
            dfs(next, step + 1);
        }
    }
}
