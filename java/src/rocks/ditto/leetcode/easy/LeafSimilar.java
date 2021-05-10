package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    // 深搜
    private void dfs(TreeNode root, List<Integer> leaves){
        if (root.left == null && root.right == null){
            leaves.add(root.val);
        }
        if (root.left != null){
            dfs(root.left, leaves);
        }
        if (root.right != null){
            dfs(root.right, leaves);
        }
    }
}
