package src.rocks.ditto.leetcode.easy;

import src.rocks.ditto.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 993. 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class IsCousins {

    /**
     * x，y节点信息
     */
    private int x;
    private TreeNode xParent;
    private int xDepth;
    private boolean xFound = false;
    private int y;
    private TreeNode yParent;
    private int yDepth;
    private boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        // 设置全局变量
        this.x = x;
        this.y = y;
        // bfs
        List<TreeNode> cur = new ArrayList<>();
        // 添加root节点
        cur.add(root);
        int depth = 0;
        while (cur.size() > 0) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    next.add(node.left);
                    check(node.left, node, depth + 1);
                }
                if (node.right != null){
                    next.add(node.right);
                    check(node.right, node, depth + 1);
                }
                // 提前结束
                if (xFound && yFound){
                    break;
                }
            }
            cur = next;
            depth++;
        }
        // 最终判断
        return xDepth == yDepth && !xParent.equals(yParent);
    }

    // 判断是不是x，y
    private void check(TreeNode node, TreeNode parent, int depth){
        if (node.val == x){
            xFound = true;
            xParent = parent;
            xDepth = depth;
        } else if (node.val == y){
            yFound = true;
            yParent = parent;
            yDepth = depth;
        }
    }
}
