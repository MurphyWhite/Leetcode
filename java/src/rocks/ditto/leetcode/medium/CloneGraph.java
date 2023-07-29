package src.rocks.ditto.leetcode.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * definition for a Node
 */
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * 133. 克隆图
 * https://leetcode.cn/problems/clone-graph/
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }

        HashMap<Integer, Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        // 把头放进去
        queue.add(node);
        // 克隆节点
        Node clone = new Node(node.val);
        visited.put(clone.val, clone);
        while (!queue.isEmpty()){
            Node origin = queue.pop();
            // 拿出克隆
            Node dest = visited.get(origin.val);
            List<Node> neighbors = dest.neighbors;
            for (Node neighbor : origin.neighbors){
                Node neighborClone;
                if (!visited.containsKey(neighbor.val)){
                    neighborClone = new Node(neighbor.val);
                    visited.put(neighborClone.val, neighborClone);
                    queue.add(neighbor);
                } else {
                    neighborClone = visited.get(neighbor.val);
                }
                neighbors.add(neighborClone);
            }
        }
        return clone;
    }

}
