package src.rocks.ditto.leetcode.medium;

import src.rocks.ditto.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class PathSum {

    /**
     * 前缀和
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.target = targetSum;
        map.put(0, 1);
        dfs(root, root.val);
        return this.ans;
    }

    private void dfs(TreeNode root, int val){
        // 如果上面遍历的位置上有和目标的差值，ans
        if (map.containsKey(val - target)){
            ans += map.get(val - target);
        }
        map.put(val, map.getOrDefault(val, 0) + 1);
        //
        if (root.left != null){
            dfs(root.left, val + root.left.val);
        }
        //
        if (root.right != null){
            dfs(root.right, val +root.right.val);
        }
        map.put(val, map.get(val) - 1);
    }

    // (前缀和，数量)
    Map<Integer, Integer> map = new HashMap<>();

    int ans, target;

}
