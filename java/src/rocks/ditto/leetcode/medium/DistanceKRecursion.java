package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DistanceKRecursion {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 需要用递归进行解决
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> results = new ArrayList<>();
        dfs(results, root, target, K, -1);
        return results;
    }

    private int dfs(List<Integer> results, TreeNode root, TreeNode target, int k, int dis){

        if (root == null || target == null){
            return -1;
        }

        // k 有可能等于0
        if (dis == k){
            results.add(root.val);
            return -1;
        }

        if (root.val == target.val){
            // 找到目标
            dis = 1;
        } else if (dis > 0){
            // 向下找k
            dis++;
        }
        /**
         * 进入左边，看dis是否大于0，大于0上层已经找到target，小于0，上层没有找到
         * left 和 right 代表当前节点离target的距离
         */
        int left = dfs(results, root.left, target, k, dis);
        /**
         * 进入右边
         */
        int right = dfs(results, root.right, target, k, dis);

        //  找到了，开始返回
        if (root.val == target.val){
            // 只有自己
            if (k == 0){
                results.add(root.val);
                return -1;
            }
            return 1;
        }
        
        // return -1告诉上边不用找了
        if (left == k || right == k) {
            results.add(root.val);
            return -1;
        }
        
        // 如果右边大于0，或左边大于0，要向另外一边继续找
        if (left > 0){
            dfs(results, root.right, target, k, left + 1);
            return left + 1;
        }
        if (right > 0){
            dfs(results, root.left, target, k, right + 1);
            return right + 1;
        }
        return  -1;
    }
}
