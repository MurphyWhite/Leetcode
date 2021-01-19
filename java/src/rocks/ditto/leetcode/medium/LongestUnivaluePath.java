package src.rocks.ditto.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //  最大长度
    private Integer result;

    public int longestUnivaluePath(TreeNode root) {
        // 初始化最大长度
        result = 0;
        getLongest(root, -1);
        return result;
    }

    /**
     * 找到与节点值相同的值的最长链
     *
     * @param root      当前节点
     * @param parentVal 父节点的值
     * @return
     */
    private int getLongest(TreeNode root, int parentVal) {

        if (root == null) {
            // 没有的时候返回0
            return 0;
        }
        int left = getLongest(root.left, root.val);

        int right = getLongest(root.right, root.val);

        if (left > 0 || right > 0) {
            // 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
            int tmp = left + right;
            // 如果比最长链还长，就替换
            if (tmp > result) {
                result = tmp;
            }
        }
        if (parentVal != root.val) {
            // 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
            return left > right ? left + 1 : right + 1;
        } else {
            // 不向父节点回溯
            return 0;
        }
    }

}
