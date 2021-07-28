package src.rocks.ditto.leetcode.medium;

import src.rocks.ditto.leetcode.common.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class DistanceK {

    /**
     * 第一次用graphy用了
     */

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        // 无向图
        int[][] graph = new int[501][3];
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 3; j++) {
                graph[i][j] = -1;
            }
        }

        translateToGraph(graph, root);
        List<Integer> results = new ArrayList<>();
        bfs(graph, target.val, K, results);
        return results;
    }

    /**
     *   dfs tree translate to graph
      */
    private void translateToGraph(int[][] graph, TreeNode root){
        if(root != null){
            if (root.left != null){
                graph[root.left.val][0] = root.val;
                graph[root.val][1] = root.left.val;
                translateToGraph(graph, root.left);
            }
            if (root.right != null){
                graph[root.right.val][0] = root.val;
                graph[root.val][2] = root.right.val;
                translateToGraph(graph, root.right);
            }
        }
    }

    private void bfs(int[][] graph, int target, int k, List<Integer> result){
        List<Integer> cur = new ArrayList<>();
        Set<Integer> visted = new HashSet<>();
        visted.add(target);
        cur.add(target);
        while (k >= 0){
            List<Integer> nextTimeQueue = new ArrayList<>();
            if (k==0){
                result.addAll(cur);
                return;
            }
            for(Integer current : cur){
                visted.add(current);
                for (Integer next : graph[current]) {
                    if (next != -1 && !visted.contains(next)) {
                        nextTimeQueue.add(next);
                    }
                }
            }
            cur = nextTimeQueue;
            k--;
        }
    }

}
