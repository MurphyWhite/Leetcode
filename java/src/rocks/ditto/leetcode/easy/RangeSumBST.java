package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.TreeNode;

/**
 * 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        // 右子树大于root, 如果大于high，忽略右子树
        if (root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        // 左子树小于root，如果root小于low，忽略左子树
        if (root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
