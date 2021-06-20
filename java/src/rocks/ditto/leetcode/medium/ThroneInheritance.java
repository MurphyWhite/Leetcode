package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1600. 皇位继承顺序
 * https://leetcode-cn.com/problems/throne-inheritance/
 */
public class ThroneInheritance {

    /**
     * 人物的模型
     */
    class Node{
        // 姓名
        String name;
        // 继承链的下一位
        Node next;
        // 最后一个孩子
        Node lastChild;
        // 是否死亡
        boolean isDead = false;
        Node (String name){
            this.name = name;
        }
    }

    // 快速查找
    Map<String, Node> map = new HashMap<>();

    // 家庭链
    Node head = new Node(""), tail = new Node("");

    /**
     * 建立王国
     * @param kingName
     */
    public ThroneInheritance(String kingName) {
        Node root = new Node(kingName);
        root.next = tail;
        head.next = root;
        map.put(kingName, root);
    }

    /**
     * 生孩子
     * @param parentName 父亲名字
     * @param childName 孩子名字
     */
    public void birth(String parentName, String childName) {
        Node node = new Node(childName);
        map.put(childName, node);
        Node parent = map.get(parentName);
        Node tmp = parent;
        // 如果最后一个儿子的儿子的后面(弟弟比不上哥哥的儿子啊)
        while (tmp.lastChild != null){
            tmp = tmp.lastChild;
        }
        // 先把位置补一下
        node.next = tmp.next;
        // 插入
        tmp.next = node;
        // 变成最后一个儿子
        parent.lastChild = node;
    }

    /**
     * 某人死亡
     * @param name 死亡名字
     */
    public void death(String name) {
        Node dead = map.get(name);
        dead.isDead = true;
    }

    /**
     * 获取继承顺序
     * @return
     */
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        Node cur = head.next;
        while (!"".equals(cur.name)){
            if (!cur.isDead){
                result.add(cur.name);
            }
            cur = cur.next;
        }
        return result;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
