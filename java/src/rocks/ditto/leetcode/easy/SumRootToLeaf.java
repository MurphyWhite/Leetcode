package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/description/?envType=daily-question&envId=2026-02-24
 */
public class SumRootToLeaf {


    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    // 深搜
    private int dfs(TreeNode root, int curr){
        // 挪一位计算加当前的
        int ans = 0, ncur = (curr << 1) + root.val;
        if (root.left!=null) ans += dfs(root.left, ncur);
        if (root.right!=null) ans += dfs(root.right, ncur);

        // 如果是叶子节点，返回当前
        if(root.left ==null && root.right ==null){
            return ncur;
        } else {
            // 如果不是，返回递归结果
            return ans;
        }
    }
}
