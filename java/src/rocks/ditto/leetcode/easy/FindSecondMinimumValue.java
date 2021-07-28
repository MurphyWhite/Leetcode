package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class FindSecondMinimumValue {

    int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    /**
     *
     * @param root 当前根节点
     * @param smallest 该树的最小值
     */
    private void dfs(TreeNode root, int smallest) {

        if (root == null) {
            return;
        }
        // 如果不等于最小值，可以做比较
        if (root.val != smallest){
            if (ans == -1) {
                ans = root.val;
            } else {
                ans = Math.min(ans, root.val);
            }
            // 找到了不同值即可返回，不需要再继续dfs
            return;
        }
        dfs(root.left, smallest);
        dfs(root.right, smallest);
    }
}
