package src.rocks.ditto.leetcode.medium;

import src.rocks.ditto.leetcode.common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        return null;
    }

    private void processNode(TreeNode current, TreeNode parent, int low, int high, int flag){
        if (current == null) {
            return;
        }
        if (current.val < low ){
            if (flag == 1){
                parent.left = current.right;
                return;
            }
        }
    }
}
