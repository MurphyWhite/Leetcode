package src.rocks.ditto.leetcode.hard;

import src.rocks.ditto.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 剑指 Offer 37. 序列化二叉树
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class SerializeAndDeserializeTree {

    /**
     * 树中结点数在范围 [0, 104] 内
     * -1000 <= Node.val <= 1000
     */
    int INF = -2000;
    TreeNode EmptyNode = new TreeNode(INF);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 空树
        if (root == null){
            return "[]";
        }
        List<String> nodes = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pollFirst();
            nodes.add(cur.equals(EmptyNode) ? String.valueOf(INF) : String.valueOf(cur.val));
            if (!cur.equals(EmptyNode)){
                deque.addLast(cur.left == null ? EmptyNode : cur.left);
                deque.addLast(cur.right == null ? EmptyNode : cur.right);
            }
        }
        return "[" + String.join(",", nodes) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 裁剪掉左右括号和空树
        if (data.startsWith("[") && data.endsWith("]") && data.length() > 3){
            data = data.substring(1, data.length() - 1);
        } else {
            return null;
        }
        String[] nodes = data.split(",");
        int n = nodes.length;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        for (int i = 1; i < n - 1; i+=2) {
            int left = Integer.parseInt(nodes[i]), right = Integer.parseInt(nodes[i+1]);
            TreeNode cur = deque.pollFirst();
            // 左节点
            if (left != INF){
                cur.left = new TreeNode(left);
                deque.addLast(cur.left);
            }
            // 右节点
            if (right != INF){
                cur.right = new TreeNode(right);
                deque.addLast(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerializeAndDeserializeTree solution = new SerializeAndDeserializeTree();
        String result = solution.serialize(root);
        System.out.println(result);


    }
}
