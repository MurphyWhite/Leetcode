package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
 */
public class PathInZigZagTree {

    /**
     * 用数学的方式解题，主要是计算
     */
    public List<Integer> pathInZigZagTree(int label) {

        int n = 1;
        // 找出label在第几层
        while (getEnd(n) < label) {
            n++;
        }
        int[] ans = new int[n];
        // 遍历层序
        int cur = n;
        int curLabel = label;
        while (cur > 0){
            ans[cur - 1] = curLabel;
            //  计算出当前的位置
            // (getEnd(cur) - curLabel) / 2
            int location = ((1 << (cur)) - 1 - curLabel) >> 1;
            // getFirst(cur - 1) + location
            curLabel = (1 << (cur - 2)) + location;
            cur--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ans) {
            list.add(i);
        }
        return list;
    }

    /**
     * 返回第level层的第一个数
     * @param level 第几层
     * @return
     */
    private int getFirst(int level) {
        return (int) Math.pow(2, level - 1);
    }

    /**
     * 返回第level层的最后一个数
     * @param level 第几层
     * @return
     */
    private int getEnd(int level) {
        int first = getFirst(level);
        // int last = (int) Math.pow(2, n) - 1;
        // 优化last
        return first + first - 1;
    }

    public static void main(String[] args) {
        PathInZigZagTree s = new PathInZigZagTree();
        System.out.println(s.pathInZigZagTree(25));
    }

}
